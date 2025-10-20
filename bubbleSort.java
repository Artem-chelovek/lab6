public class bubbleSort {

    // Метод, реализующий алгоритм пузырьковой сортировки
    public static void bubbleSort(int[] array) {
        int n = array.length;      // Получаем длину массива
        
        // Внешний цикл проходит по массиву, выполняя полный проход N-1 раз
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Переменная для отслеживания наличия обменов в данном проходе
            
            // Внутренний цикл проверяет смежные элементы и производит обмен, если они находятся в неправильном порядке
            for (int j = 0; j < n - i - 1; j++) {
                // Если текущий элемент больше следующего, меняем их местами
                if (array[j] > array[j + 1]) {
                    // Производим обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    
                    swapped = true; // Отмечаем, что произошел обмен
                }
            }
            
            // Если в течение полного прохода не произошло ни одного обмена, массив уже отсортирован
            if (!swapped) break;
        }
    }

    // Вспомогательный метод для вывода массива на экран
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Точка входа в приложение
    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Исходный массив:");
        printArray(numbers);
        
        bubbleSort(numbers); // Сортируем массив
        
        System.out.println("Отсортированный массив:");
        printArray(numbers);
    }
}
/*
Исходный массив:
64 34 25 12 22 11 90 
Отсортированный массив:
11 12 22 25 34 64 90 
*/