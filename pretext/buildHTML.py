#!/usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = "Andrew Rechnitzer"
__copyright__ = "Copyright (C) 2020 Andrew Rechnitzer"
__credits__ = ["Andrew Rechnitzer"]
__license__ = "GPL-3.0-or-later"

import os
import subprocess
import lxml.etree as ET

# source file
sourceFile = "./clp_3_mc.ptx"
# output directory
outDir = "./site"

currentDir = os.getcwd()
# xslt pretext file
xsltFile = currentDir + "/xsl/mathbook-html.xsl"
# the schema to check against
xsFile = currentDir + "/schema/pretextCLP.rng"
xs = ET.RelaxNG(ET.parse(xsFile))
# mbx location
ptx = currentDir + "/pretext/pretext"


# ["foo", pretextStuff] replaces <foo/> with pretextStuff
mySubs = [
    ["conceptual", "<p><alert>Exercises &#8212; Stage 1</alert></p>"],
    ["procedural", "<p><alert>Exercises &#8212; Stage 2</alert></p>"],
    ["application", "<p><alert>Exercises &#8212; Stage 3</alert></p>"],
    ["fromexam", "<em>&#x2733;</em>"],
]

# build parameters as dict
param = {
    "publisher": "'../pubHTML.ptx'",  # this loads in the publisher options = empty at this stage
    "exercise.divisional.answer": "'no'",
    "exercise.divisional.hint": "'no'",
    "exercise.divisional.solution": "'no'",
}


def replaceSubsTag(src, tg, sb):
    for repTag in reversed(src.findall("//{}".format(tg))):
        par = repTag.getparent()
        parIndex = par.index(repTag)
        # now insert the pre-string before the reptag
        par.insert(parIndex, ET.fromstring(sb))
        # finally remove the reptag.
        par.remove(repTag)
    return src


def userTags(src):
    for [tg, sb] in mySubs:
        src = replaceSubsTag(src, tg, sb)
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
for dir in ["site", "site/knowl", "site/figs", "site/images", "site/pfigs"]:
    os.makedirs(dir, exist_ok=True)

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
print("Processing tikz to svg")
subprocess.check_output(
    [ptx, "-c", "latex-image", "-f", "svg", "-d", "images", "../" + sourceFile]
)
