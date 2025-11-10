def quick_sort(arr):
    """
    Реализует алгоритм быстрой сортировки (quick sort).
    """
    if len(arr) <= 1:
        return arr
    
    pivot = arr[len(arr) // 2]  # Выбираем опорный элемент (pivot)
    left = []                   # Список для элементов меньше pivot
    equal = []                  # Список для элементов равных pivot
    right = []                  # Список для элементов больше pivot
    
    # Распределение элементов вокруг опорного элемента
    for x in arr:
        if x < pivot:
            left.append(x)       # Элемент добавляется в список "левых" элементов
        elif x == pivot:
            equal.append(x)      # Элемент добавляется в список "равных" элементов
        else:
            right.append(x)      # Элемент добавляется в список "правых" элементов
    
    # Рекурсивно сортируем левые и правые списки и соединяем их
    return quick_sort(left) + equal + quick_sort(right)

# Пример использования
if __name__ == "__main__":
    unsorted_data = [3, 6, 8, 10, 1, 2, 1]
    sorted_data = quick_sort(unsorted_data)
    print("Отсортированный массив:", sorted_data)
'''
Отсортированный массив: [1, 1, 2, 3, 6, 8, 10]
'''