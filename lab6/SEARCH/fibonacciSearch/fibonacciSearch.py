def fibonacci_search(arr, target):
    def fib(n):
        """Возвращает пару соседних чисел Фибоначчи."""
        a, b = 0, 1
        for _ in range(n+1):
            yield a
            a, b = b, a+b

    # Последовательность Фибоначчи должна покрывать длину массива
    k = 0
    while next(fib(k)) < len(arr):
        k += 1

    offset = -1  # Смещение относительно начала массива
    m = next(fib(k))
    m_minus_1 = next(fib(k-1))
    m_minus_2 = next(fib(k-2))

    while (m > 1):
        # Индексация элементов с учётом смещения
        i = min(offset+m_minus_2, len(arr)-1)

        if arr[i] < target:
            # Переход в правую часть
            m = m_minus_1
            m_minus_1 = m_minus_2
            m_minus_2 = m - m_minus_1
            offset = i
        elif arr[i] > target:
            # Переход в левую часть
            m = m_minus_2
            m_minus_1 -= m_minus_2
            m_minus_2 = m - m_minus_1
        else:
            # Целевой элемент найден
            return i

    # Если последний элемент последовательности совпадает с целью
    if m_minus_1 and arr[offset+1] == target:
        return offset + 1

    # Если элемент не найден
    return -1

# Пример использования
sorted_array = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
value_to_find = 85

result = fibonacci_search(sorted_array, value_to_find)

if result != -1:
    print(f"Элемент найден на позиции: {result}")
else:
    print("Элемент не найден.")