/*
Задание. Ввести n чисел с консоли.
3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
 */
package javafundamentals.optionaltasks.firstgroup;

import java.util.ArrayList;
import java.util.Scanner;

public class ThirdOptionalTask {

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

    public static int findAverageLengthOfValues(int[] initializedArray) {
        int countSum = 0;

        for (int value: initializedArray) {
            countSum += String.valueOf(Math.abs(value)).length();
        }

        return countSum/ initializedArray.length;
    }

    public static ArrayList<Integer> findNumbersLengthBiggerThanAverageLength(int[] initializedArray, int averageLengthValue){
        ArrayList<Integer> listOfBiggerNumbers = new ArrayList<>();

        for (int value: initializedArray) {
            if (String.valueOf(Math.abs(value)).length() > averageLengthValue) {
                listOfBiggerNumbers.add(value);
            }
        }

        return listOfBiggerNumbers;
    }

    public static ArrayList<Integer> findNumbersLengthSmallerThanAverageLength(int[] initializedArray, int averageLengthValue){
        ArrayList<Integer> listOfSmallerNumbers = new ArrayList<>();

        for (int value: initializedArray) {
            if (String.valueOf(Math.abs(value)).length() < averageLengthValue) {
                listOfSmallerNumbers.add(value);
            }
        }

        return listOfSmallerNumbers;
    }

    public static void printNumbersLengthBiggerOrSmallerThanAverageLength(ArrayList<Integer> listWithCheckedNumbersLength, int averageLengthValue, boolean isBigger) {
        System.out.println("The average length of number from array is " + averageLengthValue);
        if (isBigger) {
            System.out.println("The list of numbers with bigger length than average length of array all numbers:");
        }else {
            System.out.println("The list of numbers with smaller length than average length of array all numbers:");
        }
        for (Integer value: listWithCheckedNumbersLength) {
            System.out.println("value " + value + " , its length is " + String.valueOf(Math.abs(value)).length() + " ");
        }
    }


    public static void main(String[] args) {
        int[] array = initializeArrayWithNumbersByConsole();
        int averageLength = findAverageLengthOfValues(array);

        ArrayList<Integer> readyListWithNumbers = findNumbersLengthBiggerThanAverageLength(array, averageLength);
        printNumbersLengthBiggerOrSmallerThanAverageLength(readyListWithNumbers, averageLength, true);
        System.out.println();

        readyListWithNumbers = findNumbersLengthSmallerThanAverageLength(array, averageLength);
        printNumbersLengthBiggerOrSmallerThanAverageLength(readyListWithNumbers, averageLength, false);
    }
}
