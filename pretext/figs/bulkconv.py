import glob
import os

for fname in glob.glob("*.pdf"):
    pre, ext = os.path.splitext(fname)
    if os.path.isfile(pre + ".svg"):  # already converted
        pass
    else:
        os.system("pdf2svg {} {}".format(fname, pre + ".svg"))
