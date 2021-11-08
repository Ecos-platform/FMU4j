
from fmpy import *

fmu = '../fmu-builder/build/generated/Identity.fmu'

result = simulate_fmu(fmu)
print(result)
