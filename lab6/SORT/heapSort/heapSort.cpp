#include <iostream>
#include <vector>

// Функция для преобразования поддерева в max-кучу (heapify)
void heapify(std::vector<int>& arr, int n, int root) {
    int largest = root;           // Ищем наибольший элемент (начиная с корня)
    int leftChild = 2 * root + 1; // Левый дочерний узел
    int rightChild = 2 * root + 2;// Правый дочерний узел

    // Проверяем, существует ли левый ребёнок и больше ли он корня
    if (leftChild < n && arr[leftChild] > arr[largest]) {
        largest = leftChild;
    }

    // Проверяем, существует ли правый ребёнок и больше ли он корня
    if (rightChild < n && arr[rightChild] > arr[largest]) {
        largest = rightChild;
    }

    // Если наибольший элемент изменился, меняем местами и вызываем heapify рекурсивно
    if (largest != root) {
        std::swap(arr[root], arr[largest]);
        heapify(arr, n, largest); // Рекурсия для поддерева
    }
}

// Основная функция сортировки кучей (Heapsort)
void heapSort(std::vector<int>& arr) {
    int n = arr.size();           // Длина массива

    // Построение max-кучи (heapify)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);       // Преобразование массива в кучу
    }

    // Один за другим извлекаем элементы из кучи
    for (int i = n - 1; i > 0; i--) {
        std::swap(arr[0], arr[i]);// Меняем местами корень (максимальный элемент) и последний элемент
        heapify(arr, i, 0);       // Восстанавливаем кучу
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
    std::vector<int> nums = {12, 11, 13, 5, 6, 7};

    std::cout << "Исходный массив: ";
    printArray(nums);

    heapSort(nums); // Вызов функции сортировки

    std::cout << "Отсортированный массив: ";
    printArray(nums);

    return 0;
}