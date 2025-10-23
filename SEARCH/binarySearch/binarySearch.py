def binary_search(arr, target):
    left, right = 0, len(arr) - 1  # Начальные границы поиска

    while left <= right:
        mid = (left + right) // 2  # Нахождение средней позиции

        # Если средний элемент равен искомому, возвращаем его индекс
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:     # Если среднее значение меньше искомого,
            left = mid + 1           # сужаем поиск вправо
        else:                       # Если среднее значение больше искомого,
            right = mid - 1          # сужаем поиск влево

    return -1  # Если элемент не найден, возвращаем -1

# Пример использования
sorted_array = [1, 3, 5, 7, 9, 11, 13, 15]
search_value = 9

result = binary_search(sorted_array, search_value)

if result != -1:
    print(f"Искомый элемент найден на позиции {result}")
else:
    print("Искомый элемент не найден")