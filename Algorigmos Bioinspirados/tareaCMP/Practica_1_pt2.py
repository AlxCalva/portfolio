import numpy as np
import math
import matplotlib.pyplot as plt
t = np.linspace(0, 4 * np.pi, 1000)  
f_t = np.sin(2 * np.pi * t / 5 + 0.2)

f_prime_t = (2 * np.pi / 5) * np.cos(2 * np.pi * t / 5 + 0.2)
umbral = 0.01
puntos_tangente_cero = t[np.abs(f_prime_t) < umbral]

# Evaluar f(t) en esos puntos
f_t_puntos_cero = np.sin(2 * np.pi * puntos_tangente_cero / 5 + 0.2)

# Graficar la función senoidal
plt.figure(figsize=(10, 6))
plt.plot(t, f_t, label="f(t) = sin(2πt/5 + 0.2)", color="blue", linewidth=2)

# Resaltar los puntos donde la pendiente es cero (más notables)
plt.scatter(
    puntos_tangente_cero, 
    f_t_puntos_cero, 
    color="red", 
    label="Pendiente cercana a cero", 
    s=100,           # Tamaño de los puntos
    edgecolor="black", # Borde negro para mayor visibilidad
    zorder=5         # Asegurar que los puntos estén encima de la gráfica
)

# Añadir detalles a la gráfica
plt.title("Funcion sen(2*pi*t/5  +0.2) con máximos y mínimos resaltados", fontsize=14)
plt.xlabel("t (radianes)", fontsize=12)
plt.ylabel("f(t)", fontsize=12)
plt.axhline(0, color="black", linewidth=0.5)  # Eje horizontal
plt.axvline(0, color="black", linewidth=0.5)  # Eje vertical
plt.grid(True, linestyle="--", alpha=0.7)     # Cuadrícula punteada
plt.legend(fontsize=12)
plt.show()