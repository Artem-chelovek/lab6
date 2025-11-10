#include <iostream>
using namespace std;

// Реализация бинарного поиска
int binarySearch(const int arr[], int size, int target) {
    int left = 0;                  // Левая граница поиска
    int right = size - 1;          // Правая граница поиска

    while (left <= right) {         // Пока область поиска не пуста
        int mid = left + (right - left) / 2;  // Средняя позиция

        if (arr[mid] == target) {  // Если средняя точка равна искомому числу
            return mid;            // Возвращаем её индекс
        } else if (arr[mid] < target) {  // Если середина меньше искомого числа
            left = mid + 1;        // Уменьшаем область поиска слева
        } else {                    // Если середина больше искомого числа
            right = mid - 1;       // Уменьшаем область поиска справа
        }
    }

    return -1;                 // Если элемент не найден, возвращаем -1
}

// Главная функция для теста
int main() {
    const int SIZE = 10;
    int sortedArray[SIZE] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    int valueToFind = 11;        // Число, которое мы ищем

    // Производим поиск
    int result = binarySearch(sortedArray, SIZE, valueToFind);

    if (result != -1) {
        cout << "Элемент найден на позиции: " << result << endl;
    } else {
        cout << "Элемент не найден." << endl;
    }

    return 0;
}