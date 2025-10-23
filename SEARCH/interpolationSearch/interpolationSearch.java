public class interpolationSearch {

    // Реализация интерполяционного поиска
    public static int interpolationSearch(int[] arr, int x) {
        int low = 0;                     // Нижняя граница поиска
        int high = arr.length - 1;       // Верхняя граница поиска

        while ((low <= high) && (x >= arr[low]) && (x <= arr[high])) {
            // Оцениваем потенциальную позицию искомого элемента
            double pos = low + ((double)(high - low) / (arr[high] - arr[low])) * (x - arr[low]);
            
            // Преобразование в целое число (так как индекс массива должен быть целым числом)
            int mid = (int)Math.floor(pos);

            // Нашли элемент!
            if (arr[mid] == x) {
                return mid;              // Индекс найденного элемента
            }

            // Если элемент меньше среднего, продолжаем поиск слева
            if (arr[mid] < x) {
                low = mid + 1;
            }
            // Иначе — справа
            else {
                high = mid - 1;
            }
        }

        return -1;                      // Если элемент не найден
    }

    // Точка входа в программу
    public static void main(String[] args) {
        int[] sortedArray = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23};
        int elementToFind = 18;          // Значение, которое мы хотим найти

        // Выполняем поиск
        int index = interpolationSearch(sortedArray, elementToFind);

        // Результат
        if (index != -1) {
            System.out.println("Элемент найден на индексе: " + index);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}