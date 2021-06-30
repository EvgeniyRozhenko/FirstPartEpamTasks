/*
Реализовать следующие программы:
4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
 */
package javafundamentals.maintasks;

public class FourthMainTask {

    public static int countProductOfNumbers(String[] strArray) throws ArrayIsEmptyException {
        if (strArray.length == 0){
            throw new ArrayIsEmptyException("Array parameter is empty");
        }
        int productOfNumbers = 1;

        for (int i = 0; i < strArray.length; i++){
            productOfNumbers *= Integer.parseInt(strArray[i]);
        }
        return productOfNumbers;
    }

    private static class ArrayIsEmptyException extends Exception{

        public ArrayIsEmptyException(String message){
            super(message);
        }
    }

    public static void main(String[] args) throws ArrayIsEmptyException {

        System.out.println(countProductOfNumbers(args));
    }
}
