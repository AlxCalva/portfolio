import random
import numpy as np

def knapsack():
    W = 1
    n = 20
    values = [random.randint(1, 100) for _ in range(n)]
    weights = [random.uniform(0, 1) for _ in range(n)]
    print("Valores:", values)
    print("Pesos:", weights)

    def fitness(solution):
        total_value = sum(v * s for v, s in zip(values, solution))
        total_weight = sum(w * s for w, s in zip(weights, solution))
        if total_weight > W:
            return 0
        return total_value

    population_size = 100
    population = [[random.randint(0, 1) for _ in range(n)] for _ in range(population_size)]
    generations = 100

    for _ in range(generations):
        fitness_scores = [fitness(ind) for ind in population]
        parents = random.choices(population, weights=fitness_scores, k=population_size)
        offspring = []
        for i in range(0, population_size, 2):
            parent1, parent2 = parents[i], parents[i+1]
            crossover_point = random.randint(1, n-1)
            child1 = parent1[:crossover_point] + parent2[crossover_point:]
            child2 = parent2[:crossover_point] + parent1[crossover_point:]
            offspring.extend([child1, child2])
        for child in offspring:
            for i in range(n):
                if random.random() < 0.1:
                    child[i] = 1 - child[i]
        population = offspring

    best_solution = max(population, key=fitness)
    print("Elementos elegidos:", [i+1 for i in range(n) if best_solution[i]])

def coin_problem():
    d = [1, 2, 3]
    N = 6

    def fitness(solution):
        total = sum(solution)
        if total > N:
            return 0
        return (N - total) + len([c for c in solution if c > 0])

    population_size = 100
    population = [[random.randint(0, N//min(d)) for _ in range(len(d))] for _ in range(population_size)]
    generations = 100

    for _ in range(generations):
        fitness_scores = [fitness(ind) for ind in population]
        parents = random.choices(population, weights=fitness_scores, k=population_size)
        offspring = []
        for i in range(0, population_size, 2):
            parent1, parent2 = parents[i], parents[i+1]
            crossover_point = random.randint(1, len(d)-1)
            child1 = parent1[:crossover_point] + parent2[crossover_point:]
            child2 = parent2[:crossover_point] + parent1[crossover_point:]
            offspring.extend([child1, child2])
        for child in offspring:
            for i in range(len(d)):
                if random.random() < 0.1:
                    child[i] = max(0, child[i] + random.choice([-1, 1]))
        population = offspring

    best_solution = min([ind for ind in population if sum(ind) == N], key=lambda x: sum(x))
    print("Combinación de monedas:", best_solution)

def tsp():
    n_cities = 10
    distances = np.full((n_cities+1, n_cities+1), 2)
    special_pairs = [(1,3), (3,5), (5,7), (7,9), (9,2), (2,4), (4,6), (6,8), (8,10)]
    for i, j in special_pairs:
        distances[i][j] = 1
        distances[j][i] = 1

    def fitness(solution):
        total_distance = 0
        for i in range(len(solution)):
            city1 = solution[i]
            city2 = solution[(i+1)%len(solution)]
            total_distance += distances[city1][city2]
        return -total_distance

    population_size = 100
    population = [random.sample(range(1, n_cities+1), n_cities) for _ in range(population_size)]
    generations = 100

    for _ in range(generations):
        fitness_scores = [fitness(ind) for ind in population]
        parents = random.choices(population, weights=fitness_scores, k=population_size)
        offspring = []
        for i in range(0, population_size, 2):
            parent1, parent2 = parents[i], parents[i+1]
            start, end = sorted([random.randint(0, n_cities-1), random.randint(0, n_cities-1)])
            child1 = parent1[:start] + [city for city in parent2 if city not in parent1[:start]]
            child2 = parent2[:start] + [city for city in parent1 if city not in parent2[:start]]
            offspring.extend([child1, child2])
        for child in offspring:
            if random.random() < 0.1:
                i, j = random.sample(range(n_cities), 2)
                child[i], child[j] = child[j], child[i]
        population = offspring

    best_solution = max(population, key=fitness)
    print("Mejor ruta:", best_solution)
    print("Distancia total:", -fitness(best_solution))

def main():
    print("1. Knapsack")
    print("2. Problema de monedas")
    print("3. TSP")
    choice = int(input("Seleccione el problema a resolver: "))
    if choice == 1:
        knapsack()
    elif choice == 2:
        coin_problem()
    elif choice == 3:
        tsp()
    else:
        print("Opción no válida")

if __name__ == "__main__":
    main()