import subprocess

jingit = subprocess.run(
    ["jing", "/home/andrew/Projects/mathbook/schema/pretext.rng", "./clp_3_mc.ptx"],
    capture_output=True,
)

ignoreMe = []

jingout = jingit.stdout.decode()
for line in jingout.split("\n"):
    if any([x in line for x in ignoreMe]):
        continue
    print(line, "\n")
