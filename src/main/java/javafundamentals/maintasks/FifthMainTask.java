/*
Реализовать следующие программы:
5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку
корректности ввода чисел.
 */
package javafundamentals.maintasks;

public class FifthMainTask {

    public static void getMonthByNumberToConsole(int numberOfMonth) throws InvalidArgumentException {
        switch(numberOfMonth){
            case 1:
                System.out.println(numberOfMonth + " month is January");
                break;
            case 2:
                System.out.println(numberOfMonth + " month is February");
                break;
            case 3:
                System.out.println(numberOfMonth + " month is March");
                break;
            case 4:
                System.out.println(numberOfMonth + " month is April");
                break;
            case 5:
                System.out.println(numberOfMonth + " month is May");
                break;
            case 6:
                System.out.println(numberOfMonth + " month is June");
                break;
            case 7:
                System.out.println(numberOfMonth + " month is July");
                break;
            case 8:
                System.out.println(numberOfMonth + " month is August");
                break;
            case 9:
                System.out.println(numberOfMonth + " month is September");
                break;
            case 10:
                System.out.println(numberOfMonth + " month is October");
                break;
            case 11:
                System.out.println(numberOfMonth + " month is November");
                break;
            case 12:
                System.out.println(numberOfMonth + " month is December");
                break;
            default:
                throw new InvalidArgumentException("Invalid month number entered. Enter from 1 to 12");
        }
    }

    private static class InvalidArgumentException extends Exception{
        InvalidArgumentException(String message){
            super(message);
        }
    }

    private static class InvalidLengthOfArrayException extends Exception{
        InvalidLengthOfArrayException(String message){
            super(message);
        }
    }

    public static void main (String[] args) throws InvalidArgumentException, InvalidLengthOfArrayException {
        if (args.length > 1){
            throw new InvalidLengthOfArrayException("Only one number argument is expected");
        }
            getMonthByNumberToConsole(Integer.parseInt(args[0]));

    }
}
