
# export LD_LIBRARY_PATH=/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server:${LD_LIBRARY_PATH}

from fmpy import *

fmu = '../fmu-builder/build/generated/Identity.fmu'

result = simulate_fmu(fmu)
print(result)
