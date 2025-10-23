public class shellSort {

    // Основная функция сортировки методом Шелла
    public static void shellSort(int[] array) {
        int length = array.length; // Длина массива
        
        // Выбор начального шага (h) согласно формуле h = gap sequence
        // Обычно используют разные варианты, например 3x+1 или hibbard's sequence
        for (int gap = length / 2; gap > 0; gap /= 2) { // Сокращаем шаг вдвое на каждой итерации
            // Перебираем массив с шагом gap
            for (int i = gap; i < length; i += gap) {
                int temp = array[i]; // Запоминаем текущий элемент
                
                // Вставляем текущий элемент в нужную позицию среди уже упорядоченных элементов
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap]; // Сдвигаем больший элемент вперед
                    j -= gap;                  // Продвигаемся назад
                }
                array[j] = temp;               // Ставим текущий элемент на правильное место
            }
        }
    }

    // Вспомогательная функция для вывода массива
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Точка входа в программу
    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Исходный массив:");
        printArray(data);
        
        shellSort(data); // Сортируем массив методом Шелла
        
        System.out.println("Отсортированный массив:");
        printArray(data);
    }
}
/*
Исходный массив:
38 27 43 3 9 82 10
Отсортированный массив:
3 9 10 27 38 43 82
*/