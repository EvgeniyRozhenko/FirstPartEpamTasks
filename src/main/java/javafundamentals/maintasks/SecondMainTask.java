/*
Реализовать следующие программы:
2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
 */
package javafundamentals.maintasks;

import java.util.ArrayList;

public class SecondMainTask {

    public static ArrayList<String> reverseArray(String[] array) throws ArrayIsEmptyException {
        if (array.length == 0){
            throw new ArrayIsEmptyException("Array parameter is empty");
        }
        ArrayList<String> newReversedArray = new ArrayList<>();

        for (int i = array.length-1; i >= 0; i--){
            newReversedArray.add(array[i]);
        }
        return newReversedArray;
    }

    private static class ArrayIsEmptyException extends Exception{

        public ArrayIsEmptyException(String message){
            super(message);
        }
    }

    public static void main(String[] args) throws ArrayIsEmptyException {

        System.out.println(reverseArray(args).toString()
                .replace("[", "")
                .replace(",", "")
                .replace("]", ""));

    }
}
