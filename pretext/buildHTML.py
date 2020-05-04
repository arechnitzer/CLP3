#!/usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = "Andrew Rechnitzer"
__copyright__ = "Copyright (C) 2020 Andrew Rechnitzer"
__credits__ = ["Andrew Rechnitzer"]
__license__ = "GPL-3.0-or-later"

import os
import xmlschema
import lxml.etree as ET

# source file
sourceFile = "./clp_3_mc.ptx"
# xslt pretext file
xsltFile = "/home/andrew/Projects/mathbook/xsl/mathbook-html.xsl"
# the schema to check against
xs = xmlschema.XMLSchema(
    "/home/andrew/Projects/mathbook/schema/pretext.xsd", validation="lax"
)
# output directory
outDir = "./site"

# each in this list should be a 4-ple [ancestor-tag, tag, replace-before, replace-after]
myDescTags = [
    ["answer", "proof", "<p><term>Proof:</term></p>", "<p><m>\square</m></p>"],
    ["solution", "proof", "<p><term>Proof:</term></p>", "<p><m>\square</m></p>"],
]

# each tag should be a 3-ple [tag, replace-before, replace-after]
myTags = [["answerproof", "<p><term>Proof:</term></p>", "<p><m>\square</m></p>",]]

# build parameters as dict
param = {
    "exercise.divisional.answer": "'no'",
    "exercise.divisional.hint": "'no'",
    "exercise.divisional.solution": "'no'",
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


def userTags(src):
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
procd = userTags(src)

# try to validate before building
print("Validate before building")
try:
    xs.validate(procd)
except Exception as err:
    print(">>> ERROR <<< ")
    print(err)
    exit(1)

# all passed so now build

# read in the pretext xslt magic
print("Read in xsl file")
xslt = ET.parse(xsltFile)

# and build the transform
print("Load the transform")
transform = ET.XSLT(xslt)
os.chdir(outDir)

# apply the pretext transforms to the processed-src
print("Transform the source")
htmlSource = transform(procd, **param)
print("HTML written")
print("Error log:")
print(transform.error_log)
