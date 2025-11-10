#include <iostream>
#include <vector>

// Вспомогательная функция для объединения двух отсортированных частей массива
void merge(std::vector<int>& arr, int low, int middle, int high) {
    int n1 = middle - low + 1; // Размер левой части
    int n2 = high - middle;    // Размер правой части

    // Создаем временные массивы для левой и правой частей
    std::vector<int> L(n1), R(n2);

    // Копируем данные в временные массивы
    for (int i = 0; i < n1; i++) {
        L[i] = arr[low + i];
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[middle + 1 + j];
    }

    // Индексы для временного массива L, временного массива R и основного массива arr
    int i = 0, j = 0, k = low;

    // Процесс слияния двух временных массивов в основную структуру
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++; // Передвигаемся дальше по основному массиву
    }

    // Остались элементы в левом массиве
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Остались элементы в правом массиве
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// Основная рекурсивная функция сортировки слиянием
void mergeSort(std::vector<int>& arr, int low, int high) {
    if (low < high) {
        // Среднее значение для разделения массива
        int middle = low + (high - low) / 2;

        // Рекурсивно сортируем левую и правую половины
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, high);

        // Объединяем отсортированные половины
        merge(arr, low, middle, high);
    }
}

// Функция для вывода массива
void printArray(const std::vector<int>& arr) {
    for (int num : arr) {
        std::cout << num << " ";
    }
    std::cout << "\n";
}

// Точка входа в программу
int main() {
    std::vector<int> nums = {38, 27, 43, 3, 9, 82, 10};

    std::cout << "Исходный массив:\n";
    printArray(nums);

    mergeSort(nums, 0, nums.size() - 1);

    std::cout << "Отсортированный массив:\n";
    printArray(nums);

    return 0;
}
/*
Исходный массив: 38 27 43 3 9 82 10 
Отсортированный массив: 3 9 10 27 38 43 82
*/