
public class fibonacciSearch {

    private static int fibonacciSearch(int[] arr, int target) {
        // Генератор чисел Фибоначчи
        int fibKMinus2 = 0; // F[k−2]
        int fibKMinus1 = 1; // F[k−1]
        int fibK = fibKMinus2 + fibKMinus1; // F[k], начнем с наименьших возможных чисел Фибоначчи

        // Находим минимальное число Фибоначчи такое, что оно больше или равно длине массива
        while (fibK < arr.length) {
            fibKMinus2 = fibKMinus1;
            fibKMinus1 = fibK;
            fibK = fibKMinus2 + fibKMinus1;
        }

        int offset = -1; // Отступ от начала массива

        // Пока остаток от чисел Фибоначчи больше единицы
        while (fibK > 1) {
            // Рассчитываем индекс среднего элемента
            int i = Math.min(offset + fibKMinus2, arr.length - 1);

            // Если элемент меньше нужного, идём направо
            if (arr[i] < target) {
                fibK = fibKMinus1;
                fibKMinus1 = fibKMinus2;
                fibKMinus2 = fibK - fibKMinus1;
                offset = i;
            }
            // Если элемент больше нужного, идём налево
            else if (arr[i] > target) {
                fibK = fibKMinus2;
                fibKMinus1 -= fibKMinus2;
                fibKMinus2 = fibK - fibKMinus1;
            }
            // Если элемент найден
            else {
                return i;
            }
        }

        // Проверяем крайний случай, если первый элемент массива равен искомому
        if (fibKMinus1 == 1 && arr[offset + 1] == target) {
            return offset + 1;
        }

        return -1; // Если элемент не найден
    }

    public static void main(String[] args) {
        int[] sortedArray = new int[]{10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        int targetValue = 85;

        int result = fibonacciSearch(sortedArray, targetValue);

        if (result != -1) {
            System.out.println("Элемент найден на позиции: " + result);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}