#include <iostream>
using namespace std;

// Функция реализует интерполяционный поиск в отсортированном массиве
int interpolationSearch(int arr[], int n, int x) {
    int low = 0;              // Нижний индекс области поиска
    int high = n - 1;         // Верхний индекс области поиска

    while ((low <= high) && (x >= arr[low]) && (x <= arr[high])) {
        // Вычисление следующей позиции поиска
        int pos = low + (((double)(high - low) / (arr[high] - arr[low])) * (x - arr[low]));

        // Найденный элемент?
        if (arr[pos] == x) {
            return pos;       // Вернуть индекс найденного элемента
        }

        // Продолжаем поиск слева, если элемент меньше текущего
        if (arr[pos] < x) {
            low = pos + 1;
        }
        // Или справа, если больше
        else {
            high = pos - 1;
        }
    }

    return -1;               // Если элемент не найден, вернуть -1
}

// Основная программа для демонстрации работы поиска
int main() {
    int arr[] = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23};
    int n = sizeof(arr)/sizeof(arr[0]);
    int x = 18;                   // Искать элемент '18'

    int index = interpolationSearch(arr, n, x);

    if(index != -1) {
        cout << "Элемент найден на индексе: " << index << endl;
    } else {
        cout << "Элемент не найден." << endl;
    }

    return 0;
}