import numpy as np
import matplotlib.pyplot as plt

def rastrigin(x, y):
    return 20 + x**2 + y**2 - 10 * (np.cos(2 * np.pi * x) + np.cos(2 * np.pi * y))

def initialize_population(size):
    return np.random.uniform(-5.12, 5.12, (size, 2))

def mutate(child, mutation_rate):
    if np.random.rand() < mutation_rate:
        child += np.random.normal(0, 0.5, size=child.shape)
    return np.clip(child, -5.12, 5.12)

def crossover(parent1, parent2):
    alpha = np.random.rand()
    return alpha * parent1 + (1 - alpha) * parent2

def select_parents(pop, fitness):
    idx = np.random.choice(len(pop), size=2, replace=False, p=fitness/fitness.sum())
    return pop[idx[0]], pop[idx[1]]

def genetic_algorithm(generations=100, pop_size=100, mutation_rate=0.1):
    pop = initialize_population(pop_size)
    x = np.linspace(-5.12, 5.12, 100)
    y = np.linspace(-5.12, 5.12, 100)
    X, Y = np.meshgrid(x, y)
    Z = rastrigin(X, Y)
    
    for gen in range(generations):
        fitness = 1 / (1 + np.array([rastrigin(x, y) for x, y in pop]))
        new_pop = []
        for _ in range(pop_size):
            p1, p2 = select_parents(pop, fitness)
            child = crossover(p1, p2)
            child = mutate(child, mutation_rate)
            new_pop.append(child)
        pop = np.array(new_pop)
        
        plt.clf()
        plt.contourf(X, Y, Z, levels=50, cmap='viridis')
        plt.colorbar()
        plt.scatter(pop[:, 0], pop[:, 1], color='red', s=10)
        plt.title(f'Generation {gen + 1}')
        plt.pause(0.1)
    
    best = pop[np.argmin([rastrigin(x, y) for x, y in pop])]
    return best

plt.ion()
best = genetic_algorithm()
plt.ioff()
plt.show()
