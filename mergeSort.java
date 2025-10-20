import java.util.Arrays; // Для наглядности используем Arrays.toString()

class mergeSort {
    // Основная рекурсивная функция сортировки слиянием
    public static void mergeSort(int[] array) {
        if (array.length <= 1) return; // Базовый случай: массив длиной 1 или пустой уже отсортирован
        
        // Разделение массива пополам
        int mid = array.length / 2;
        int[] leftHalf = new int[mid]; // Левая половина
        int[] rightHalf = new int[array.length - mid]; // Правая половина
        
        // Копируем левую половину массива
        System.arraycopy(array, 0, leftHalf, 0, mid);
        
        // Копируем правую половину массива
        System.arraycopy(array, mid, rightHalf, 0, array.length - mid);
        
        // Рекурсивно сортируем обе половины
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        
        // Объединяем две отсортированные половинки
        merge(leftHalf, rightHalf, array);
    }

    // Процедура объединения двух отсортированных частей
    private static void merge(int[] left, int[] right, int[] result) {
        int l = 0; // Индексация левой части
        int r = 0; // Индексация правой части
        int index = 0; // Индексация результирующего массива
        
        // Слияние отсортированных частей
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[index++] = left[l++];
            } else {
                result[index++] = right[r++];
            }
        }
        
        // Добавление оставшихся элементов левой части
        while (l < left.length) {
            result[index++] = left[l++];
        }
        
        // Добавление оставшихся элементов правой части
        while (r < right.length) {
            result[index++] = right[r++];
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        mergeSort(array); // Вызов процедуры сортировки
        
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}
/*
Исходный массив: [38, 27, 43, 3, 9, 82, 10]
Отсортированный массив: [3, 9, 10, 27, 38, 43, 82]
*/