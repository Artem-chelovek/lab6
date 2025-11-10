#include <iostream>
#include <vector>

// Вспомогательная функция для разбиения массива на две части
int partition(std::vector<int>& arr, int low, int high) {
    int pivot = arr[(low + high) / 2]; // Выбираем средний элемент в качестве опорного
    int i = low - 1;                   // Левый указатель
    int j = high + 1;                  // Правый указатель
    
    // Сдвигаем указатели внутрь, пока не произойдёт пересечение
    while (true) {
        do {
            i++; // Найти элемент, который больше или равен pivot
        } while (arr[i] < pivot);
        
        do {
            j--; // Найти элемент, который меньше или равен pivot
        } while (arr[j] > pivot);
        
        if (i >= j) return j; // Выход из цикла, если указатели пересеклись
        
        // Меняем местами элементы
        std::swap(arr[i], arr[j]);
    }
}

// Основная рекурсивная функция быстрой сортировки
void quickSort(std::vector<int>& arr, int low, int high) {
    if (low < high) {
        // Разбиваем массив на две части и получаем границу раздела
        int pi = partition(arr, low, high);
        
        // Рекурсивно сортируем левую и правую части
        quickSort(arr, low, pi);      // Левая часть
        quickSort(arr, pi + 1, high); // Правая часть
    }
}

// Функция для вывода массива
void printArray(const std::vector<int>& arr) {
    for (int val : arr) {
        std::cout << val << " ";
    }
    std::cout << std::endl;
}

// Точка входа в программу
int main() {
    std::vector<int> nums = {64, 34, 25, 12, 22, 11, 90};
    
    std::cout << "Исходный массив:" << std::endl;
    printArray(nums);
    
    quickSort(nums, 0, nums.size() - 1); // Вызов сортировки
    
    std::cout << "Отсортированный массив:" << std::endl;
    printArray(nums);
    
    return 0;
}
/*
Исходный массив:
64 34 25 12 22 11 90 
Отсортированный массив:
11 12 22 25 34 64 90
*/