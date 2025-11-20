import random

def aco_knapsack(weights, values, W, n_ants, n_iter):

    n = len(weights)
    alpha=1.0
    beta=2.0
    rho=0.1
    Q=1.0
    # Инициализация феромонов на рёбрах (i → j)
    pheromone = [[1.0 for _ in range(n)] for _ in range(n)]

    best_value = 0
    best_items = []

    for it in range(n_iter):
        all_solutions = []
        for ant in range(n_ants):
            solution = []
            total_weight = 0
            current_item = None
            while True:
                # --- 1. Список допустимых предметов ---
                feasible = [i for i in range(n)
                            if i not in solution and total_weight + weights[i] <= W]

                if not feasible:
                    break

                # --- 2. Вычисление вероятностей выбора ---
                scores = []
                for j in feasible:
                    tau = pheromone[current_item][j] if current_item is not None else 1.0
                    eta = values[j] / weights[j]  # удельная ценность
                    score = (tau ** alpha) * (eta ** beta)
                    scores.append(score)

                total_score = sum(scores)
                probs = [s / total_score for s in scores]

                # --- 3. Рулетка: стохастический выбор ---
                r = random.random()
                cum = 0.0
                for idx, p in enumerate(probs):
                    cum += p
                    if r <= cum:
                        chosen = feasible[idx]
                        break

                # добавляем предмет
                solution.append(chosen)
                total_weight += weights[chosen]
                current_item = chosen

            total_value = sum(values[i] for i in solution)
            all_solutions.append((solution, total_value))

        # --- Обновление феромонов ---
        # 4. Испарение
        for i in range(n):
            for j in range(n):
                pheromone[i][j] *= (1 - rho)
                if pheromone[i][j] < 1e-6:
                    pheromone[i][j] = 1e-6

        # 5. Усиление феромонов лучшими решениями
        # (используем глобально лучшее решение итерации)
        iter_best_sol, iter_best_val = max(all_solutions, key=lambda x: x[1])

        for k in range(len(iter_best_sol) - 1):
            i = iter_best_sol[k]
            j = iter_best_sol[k + 1]
            pheromone[i][j] += Q / iter_best_val

        # Обновление глобального лучшего
        if iter_best_val > best_value:
            best_value = iter_best_val
            best_items = iter_best_sol[:]

    return best_items, best_value
print("Введите количество предметов:")
n = int(input())

weights = []
values = []

print("\nВведите вес и ценность каждого предмета:")
for i in range(n):
    w = float(input(f"Вес предмета {i+1}: "))
    v = float(input(f"Ценность предмета {i+1}: "))
    weights.append(w)
    values.append(v)

W = float(input("\nВведите максимальный вес рюкзака W: "))

print("\nПараметры ACO (нажмите Enter для значений по умолчанию):")
n_ants = input("Количество муравьёв (например 20): ")
n_iter = input("Количество итераций (например 50): ")

n_ants = int(n_ants) if n_ants.strip() else 20
n_iter = int(n_iter) if n_iter.strip() else 50

# Вызов алгоритма
best_items, best_value = aco_knapsack(weights, values, W, n_ants, n_iter)

print("\n========== РЕЗУЛЬТАТ ==========")
print("Лучшие выбранные предметы (их номера):", [(i+1) for i in best_items])
print("Итоговая ценность:", best_value)
print("Общий вес:", sum(weights[i] for i in best_items))
'''

Введите количество предметов:
5

Введите вес и ценность каждого предмета:
Вес предмета 1: 3
Ценность предмета 1: 8
Вес предмета 2: 2
Ценность предмета 2: 4
Вес предмета 3: 1
Ценность предмета 3: 3
Вес предмета 4: 4
Ценность предмета 4: 5
Вес предмета 5: 5
Ценность предмета 5: 10

Введите максимальный вес рюкзака W: 8

Параметры ACO (нажмите Enter для значений по умолчанию):
Количество муравьёв (например 20): 
Количество итераций (например 50): 

========== РЕЗУЛЬТАТ ==========
Лучшие выбранные предметы (их номера): [1, 5]
Итоговая ценность: 18.0
Общий вес: 8.0

'''