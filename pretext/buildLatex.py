#!/usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = "Andrew Rechnitzer"
__copyright__ = "Copyright (C) 2020 Andrew Rechnitzer"
__credits__ = ["Andrew Rechnitzer"]
__license__ = "GPL-3.0-or-later"

import os
import subprocess
import lxml.etree as ET

# Hopefully only these paths need setting
pretextPath = "/home/andrew/Projects/mathbook"
# source file
sourceFile = "./clp_3_mc.ptx"
# output file
outFile = "clp_3_mc.tex"

# Hopefully don't need hacking
# xslt pretext file
xsltFile = pretextPath + "/xsl/mathbook-latex.xsl"
# the schema to check against
xsFile = pretextPath + "/schema/pretext.rng"
xs = ET.RelaxNG(ET.parse(xsFile))
# mbx location
mbx = pretextPath + "/script/mbx"

# now some tag operations
# each in this list should be a 4-ple [ancestor-tag, tag, replace-before, replace-after]
# I needed this for something for the proof-book
myDescTags = []

# each tag should be a 3-ple [tag, replace-before, replace-after]
myTags = [
    [
        "answerproof",
        "<p><term>Proof:</term></p>",
        "<p><m>\square</m></p>",
    ],  # this was for a proof in an exercise answer
]

# These ["foo", "bar"] does replacement of <foo> with <bar>
# Joel - you might want these when hacking the pretext image sizes, and then comment out to do a proper compile.
myRep = [
    # I had these set so that I could see all parts of exercises on page.
    # breaks validation, but really helps debugging.
    # ["hint", "statement",],
    # ["answer", "statement"],
    # ["solution", "statement"],
]

# ["foo", pretextStuff] replaces <foo/> with pretextStuff
mySubs = [
    ["conceptual", "<p><alert>Exercises &#8212; Stage 1</alert></p>"],
    ["procedural", "<p><alert>Exercises &#8212; Stage 2</alert></p>"],
    ["application", "<p><alert>Exercises &#8212; Stage 3</alert></p>"],
    ["fromexam", "<m>\\ast</m>"],
]

# build parameters as dict
param = {
    "exercise.divisional.answer": "'yes'",
    "exercise.divisional.hint": "'yes'",
    "exercise.divisional.solution": "'yes'",
}


# if tg is descendant of atg then replace it with pre + post.
def replaceDescTag(src, atg, tg, pre, post):
    # do replacements in reverse so as to not mess up indices as we insert
    for repTag in reversed(src.findall("//{}//{}".format(atg, tg))):
        par = repTag.getparent()
        parIndex = par.index(repTag)
        # insert the post-string after the current reptag.
        par.insert(parIndex + 1, ET.fromstring(post))
        # then move up all the child-nodes - in reverse order so as to not mess up indices
        for child in reversed(repTag):
            par.insert(parIndex, child)
        # now insert the pre-string before the reptag
        par.insert(parIndex, ET.fromstring(pre))
        # finally remove the reptag.
        par.remove(repTag)
    return src


# replace tg with pre + post.
def replaceTag(src, tg, pre, post):
    # do replacements in reverse so as to not mess up indices as we insert
    for repTag in reversed(src.findall("//{}".format(tg))):
        par = repTag.getparent()
        parIndex = par.index(repTag)
        # insert the post-string after the current reptag.
        par.insert(parIndex + 1, ET.fromstring(post))
        # then move up all the child-nodes - in reverse order so as to not mess up indices
        for child in reversed(repTag):
            par.insert(parIndex, child)
        # now insert the pre-string before the reptag
        par.insert(parIndex, ET.fromstring(pre))
        # finally remove the reptag.
        par.remove(repTag)
    return src


def replaceSubsTag(src, tg, sb):
    for repTag in reversed(src.findall("//{}".format(tg))):
        par = repTag.getparent()
        parIndex = par.index(repTag)
        # now insert the pre-string before the reptag
        par.insert(parIndex, ET.fromstring(sb))
        # finally remove the reptag.
        par.remove(repTag)
    return src


def repTag(src, tg, sb):
    print("Replacing tag {} with {}".format(tg, sb))
    for repTag in src.findall("//{}".format(tg)):
        repTag.tag = sb
    return src


def userTags(src):
    for [tg, sb] in myRep:
        src = repTag(src, tg, sb)
    for [tg, sb] in mySubs:
        src = replaceSubsTag(src, tg, sb)
    for [tg, pre, post] in myTags:
        src = replaceTag(src, tg, pre, post)
    for [atg, tg, pre, post] in myDescTags:
        src = replaceDescTag(src, atg, tg, pre, post)
    return src


print("Reading in source file")
# read in the source file
src = ET.parse(sourceFile)
# and its xincludes
try:
    src.xinclude()
except Exception as err:
    print(">>> ERROR <<< ")
    print(err)
    exit(1)

# now process any user tags
print("Processing any user tags")
try:
    procd = userTags(src)
except Exception as err:
    print(">>> ERROR <<< ")
    print(err)
    exit(1)

# try to validate before building
print("Validate before building")
try:
    if xs.validate(procd):
        print("\tSource is valid")
    else:
        print("\tValidation problems:")
        print(xs.error_log)
except Exception as err:
    print(">>> ERROR <<< ")
    print(err)
    exit(1)

# all passed so now build
os.makedirs("site", exist_ok=True)

# read in the pretext xslt magic
print("Read in xsl file")
xslt = ET.parse(xsltFile)

# and build the transform
print("Load the transform")
transform = ET.XSLT(xslt)

# apply the pretext transforms to the processed-src
print("Transform the source")
latexSource = transform(procd, **param)
print("Writing LaTeX")
with open(outFile, "w") as fh:
    fh.write(str(latexSource))

print("Error log:")
print(transform.error_log)
