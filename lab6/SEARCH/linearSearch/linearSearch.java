public class linearSearch {
    
    // Метод осуществляет линейный поиск элемента target в массиве arr
    public static int linearSearch(int[] arr, int target) {        
        for (int i = 0; i < arr.length; i++) {      // Проходим по каждому элементу массива
            if (arr[i] == target) {                // Если нашли искомый элемент...
                return i;                          // Возвращаем индекс найденного элемента
            }
        }
        return -1;                                 // Если элемент не найден, возвращаем -1
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 80, 30, 60, 50};   // Создаем тестовый массив

        int keyToFind = 80;                        // Элемент, который мы хотим найти

        int resultIndex = linearSearch(array, keyToFind); // Запускаем метод поиска

        if(resultIndex != -1){
            System.out.println("Element found at index: " + resultIndex);
        } else{
            System.out.println("Element not found in the array");
        }
    }
}