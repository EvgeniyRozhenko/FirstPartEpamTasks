/*
Реализовать следующие программы:
3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 */
package javafundamentals.maintasks;

import java.util.Arrays;
import java.util.Random;

public class ThirdMainTask {

    public static void printGivenRandomNumbersWithNewLine(int amountOfRandomNumbers, int maxRandomNumberBoundary) throws ZeroParametersPassingException {
        if (amountOfRandomNumbers == 0 || maxRandomNumberBoundary == 0){
            throw new ZeroParametersPassingException("<amountOfRandomNumbers> or <maxRandomNumberBoundary> parameter can't be zero!");
        }
        Random randomNumbers = new Random();
        int[] arrayWithRandomNumbers = new int[amountOfRandomNumbers];

        for (int i = 0; i < amountOfRandomNumbers; i++){
            arrayWithRandomNumbers[i] = randomNumbers.nextInt(maxRandomNumberBoundary);
            System.out.println(arrayWithRandomNumbers[i]);
        }
    }

    public static void printGivenRandomNumbersWithoutNewLine(int amountOfRandomNumbers, int maxRandomNumberBoundary) throws ZeroParametersPassingException {
        if (amountOfRandomNumbers == 0 || maxRandomNumberBoundary == 0){
            throw new ZeroParametersPassingException("<amountOfRandomNumbers> or <maxRandomNumberBoundary> parameter can't be zero!");
        }
        Random randomNumbers = new Random();
        int[] arrayWithRandomNumbers = new int[amountOfRandomNumbers];

        for (int i = 0; i < amountOfRandomNumbers; i++){
            arrayWithRandomNumbers[i] = randomNumbers.nextInt(maxRandomNumberBoundary);
        }

        System.out.println(Arrays.toString(arrayWithRandomNumbers).replace("[", "").replace(",", "").replace("]", ""));
    }

    private static class ZeroParametersPassingException extends Exception{

        ZeroParametersPassingException(String message){
            super(message);
        }
    }

    public static void main(String[] args) throws ZeroParametersPassingException {
        printGivenRandomNumbersWithNewLine(8,99);
        printGivenRandomNumbersWithoutNewLine(10, 57);
    }
}
