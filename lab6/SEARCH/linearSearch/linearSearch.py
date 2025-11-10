def linear_search(arr, target):
    # Перебор всех элементов списка arr
    for idx in range(len(arr)):
        # Проверка текущего элемента на равенство искомому значению
        if arr[idx] == target:
            # Возврат индекса первого совпадающего элемента
            return idx
    # Если элемент не найден, возврат -1
    return -1


# Тестируем функцию
array = [10, 20, 80, 30, 60, 50]
key_to_find = 80

# Вызываем функцию поиска
result_index = linear_search(array, key_to_find)

# Анализ результата
if result_index != -1:
    print(f'Элемент найден на индексе: {result_index}')
else:
    print('Элемент не найден')