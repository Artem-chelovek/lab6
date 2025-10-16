public class selectionSort {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11, 90, 5, 3}; // Исходный массив
        
        System.out.println("Исходный массив:");
        printArray(array); // Печать исходного массива перед сортировкой
        
        selectionSort(array); // Выполнение сортировки выбором
        
        System.out.println("\nОтсортированный массив:");
        printArray(array); // Печать результата после сортировки
    }

    /**
     * Метод сортировки выбором.
     *
     * @param arr Массив целых чисел, подлежащий сортировке.
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length; // Получение размера массива
        
        for (int i = 0; i < n - 1; i++) { // Цикл по элементам массива
            int minIndex = i; // Индекс минимального элемента пока считаем текущий
            
            // Поиск минимального элемента в оставшейся части массива
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) { // Если находим новый минимум
                    minIndex = j; // Запоминаем индекс нового минимального элемента
                }
            }
            
            // Меняем текущий элемент с минимальным найденным значением
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Выводит содержимое массива на экран.
     *
     * @param arr Массив, который нужно вывести.
     */
    public static void printArray(int[] arr) {
        for (int value : arr) { // Проходим по всем элементам массива
            System.out.print(value + " "); // Выводим каждое значение
        }
        System.out.println(); // Новая строка после вывода массива
    }
}
/*
Исходный массив:
64 25 12 22 11 90 5 3 

Отсортированный массив:
3 5 11 12 22 25 64 90 
*/