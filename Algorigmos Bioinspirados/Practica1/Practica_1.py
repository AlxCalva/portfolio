import numpy as np
import math
import matplotlib.pyplot as plt
L= np.random.uniform(-1000,1001,100)

max1=-1000.0
max2=-1000.0

min1 =1000.0
min2 =1000.0
for x in L:
    if x>max1:
        max1=x
    if x<min1:
        min1 = x
for x in L:
    if x>max2 and x<max1:
        max2=x
    if x<min2 and x>min1:
        min2 = x

print(f"Los numeros mas grandes: \n{max1} \n{max2}")
print(f"Los numeros mas pequeños: \n{min1} \n{min2}")
