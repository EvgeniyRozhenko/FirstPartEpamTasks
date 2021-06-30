/*
Задание. Ввести n чисел с консоли.
2. Вывести числа в порядке возрастания (убывания) значений их длины.
 */
package javafundamentals.optionaltasks.firstgroup;

import java.util.Arrays;
import java.util.Scanner;

public class SecondOptionalTask {

    public static int[] initializeArrayWithNumbersByConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the length of the array");
        int[] arrayOfNumbers = new int[scanner.nextInt()];
        System.out.println("Initialize array by " + arrayOfNumbers.length + " numbers");
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = scanner.nextInt();
        }
        return arrayOfNumbers;
    }

    public static int[] sort(int [] array, boolean doInAscendingOrder) {
        int index;
        for (int i = 0; i < array.length; i++) {
            index = i;
            for (int j = i+1; j < array.length; j++) {
                if (doInAscendingOrder) {
                    if (String.valueOf(Math.abs(array[j])).length() < String.valueOf(Math.abs(array[index])).length()){
                        index = j;
                    }
                }else if (String.valueOf(Math.abs(array[j])).length() > String.valueOf(Math.abs(array[index])).length()){
                    index = j;
                }
            }
            if (index != i) {
                int exchangeBuffer = array[i];
                array[i] = array[index];
                array[index] = exchangeBuffer;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = initializeArrayWithNumbersByConsole();
        System.out.println(Arrays.toString(array));

        int[] sortedArray = sort(array, true);
        System.out.println(Arrays.toString(sortedArray));

        sortedArray = sort(array, false);
        System.out.println(Arrays.toString(sortedArray));

    }
}
