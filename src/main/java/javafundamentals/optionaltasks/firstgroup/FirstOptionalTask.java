/*
Задание. Ввести n чисел с консоли.
1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
 */
package javafundamentals.optionaltasks.firstgroup;

import java.util.Arrays;
import java.util.Scanner;

public class FirstOptionalTask {

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

    public static int[] findMinOrMaxValueLengthInArray(int[] arrayForSearching, boolean isMaxSearching) {
        int value = 0;
        int lengthValue = 1;
        int lengthOfValueFromArray;

        for (int valueFromArray: arrayForSearching) {
            lengthOfValueFromArray = String.valueOf(Math.abs(valueFromArray)).length();
            if (isMaxSearching) {
                if (lengthOfValueFromArray > lengthValue){
                    value = valueFromArray;
                    lengthValue = lengthOfValueFromArray;
                }
            }else if (lengthOfValueFromArray < lengthValue) {
                value = valueFromArray;
                lengthValue = lengthOfValueFromArray;
            }
        }
        return new int[]{value, lengthValue};
    }

    public static void printFoundMinAndMaxNumberLength(int[] arrayWithSmallestLengthNum, int[] arrayWithBiggestLengthNum) {
        System.out.println("The smallest value by length is: " + arrayWithSmallestLengthNum[0] + ", its length is " + arrayWithSmallestLengthNum[1]);
        System.out.println("The biggest value by length is: " + arrayWithBiggestLengthNum[0] + ", its length is " + arrayWithBiggestLengthNum[1]);
    }

    public static void main(String[] args) {
        int[] array = initializeArrayWithNumbersByConsole();
        System.out.println(Arrays.toString(array));
        printFoundMinAndMaxNumberLength(findMinOrMaxValueLengthInArray(array, false), findMinOrMaxValueLengthInArray(array, true));
    }
}
