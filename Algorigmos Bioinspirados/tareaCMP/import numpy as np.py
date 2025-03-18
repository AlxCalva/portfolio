import numpy as np
import math
import matplotlib.pyplot as plt
L= np.random.uniform(-1000,1001,100)

max=-1000.0
min =1000.0
for x in L
    if x>max 
        max=x
    if x<min
        min = x

print("El número máximo en la lista generada es: ",max)
print("El número minimo en la lista generada es: ",min)


F=[]
for x in range(0,4*)

amplitud = 1      
frecuencia = 1    
fase = 0          
n_puntos = 1000   
periodos = 2      

rango_t = 2 * math.pi * periodos  # Rango 0 a 4π
paso_t = rango_t / n_puntos

for i in range(n_puntos):
    t_i = i * paso_t  # Valor de t en el paso i
    f_t_i = amplitud * math.sin(2 * math.pi * frecuencia * t_i + fase)  # Valor de f(t)
    t.append(t_i)  # Agregar t_i a la lista t
    F.append(f_t_i)  # Agregar f_t_i a la lista F


f_prime_t_i = amplitud * 2 * math.pi * frecuencia * math.cos(2 * math.pi * frecuencia * t_i + fase)

if abs(f_prime_t_i) < 0.01:  # Umbral para considerar la pendiente como cero
        t_pendiente_cero.append(t_i)
        F_pendiente_cero.append(f_t_i)

plt.figure(figsize=(10, 6))
plt.plot(t, F, label="f(t) = sin(t)", color="blue")

plt.scatter(t_pendiente_cero, F_pendiente_cero, color="red", label="Pendiente cero", zorder=5)


plt.title("Dos periodos de la función senoidal con puntos de pendiente cero")
plt.xlabel("t (radianes)")
plt.ylabel("f(t)")
plt.axhline(0, color="black", linewidth=0.5)  # Eje horizontal
plt.axvline(0, color="black", linewidth=0.5)  # Eje vertical
plt.grid(True)
plt.legend()
plt.show()