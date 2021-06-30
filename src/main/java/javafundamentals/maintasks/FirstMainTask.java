/*
Реализовать следующие программы:
1. Приветствовать любого пользователя при вводе его имени через командную строку.
 */
package javafundamentals.maintasks;

public class FirstMainTask {

    public static void greeting(String nameFromArgs){
        if (nameFromArgs == null){
            throw new NullPointerException("Check the name parameter to null!");
        }
        System.out.println("Hi, " + nameFromArgs + "! How are you doing!");
    }

    private static class CheckNameThroughArgsException extends Exception{

        public CheckNameThroughArgsException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0){
            throw new CheckNameThroughArgsException("Length of args array is 0 - expected String name in");
        }
        String nameFromArgs = args[0];
        FirstMainTask.greeting(nameFromArgs);
    }
}

