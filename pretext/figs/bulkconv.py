import glob
import os

for fname in glob.glob("*.pdf"):
    pre, ext = os.path.splitext(fname)
    os.system("pdf2svg {} {}".format(fname, pre + ".svg"))
