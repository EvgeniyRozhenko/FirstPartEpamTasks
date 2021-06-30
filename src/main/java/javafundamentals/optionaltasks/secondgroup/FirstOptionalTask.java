/*
Задание. Ввести с консоли n - размерность матрицы a [n] [n].
Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
4. Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
 */
package javafundamentals.optionaltasks.secondgroup;

import java.util.Random;
import java.util.Scanner;

public class FirstOptionalTask {

    public static int[][] setLengthOfTwoDimensionalArrayMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the length of the matrix");

        return new int[scanner.nextInt()][scanner.nextInt()];
    }

    public static void initializeMatrixByRandomNumbers(int[][] initialMatrix) {
        Random random = new Random();

        for (int i = 0; i < initialMatrix.length; i++) {
            for (int j = 0; j < initialMatrix[i].length; j++) {

                initialMatrix[i][j] = random.nextInt(201) - 100;
            }
        }
    }

    public static void printMatrix(int[][] initialMatrix) {
        for (int[] index : initialMatrix) {
            for (int value : index) {

                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[] findMaxValueFromMatrix(int[][] initialMatrix) {
        int maxValue = initialMatrix[0][0];
        int lineIndex = -1;
        int columnIndex = -1;

        for (int i = 0; i < initialMatrix.length; i++) {
            for (int j = 0; j < initialMatrix[i].length; j++) {

                if (maxValue < initialMatrix[i][j]) {
                    maxValue = initialMatrix[i][j];
                    lineIndex = i;
                    columnIndex = j;
                }
            }
        }

        return new int[]{maxValue, lineIndex, columnIndex};
    }

    public static int[][] deleteAsBombermanMaxValueFromMatrix(int[][] initialMatrix, int[] mapWithMaxNumberData) {
        int[][] newMatrix = new int[initialMatrix.length-1][initialMatrix[0].length-1];
        int newMatrixRow = 0;
        int newMatrixColumn = 0;

        for (int i = 0; i < initialMatrix.length; i++) {

            if (i != mapWithMaxNumberData[1]){
                for (int j = 0; j < initialMatrix[0].length; j++) {

                    if (j != mapWithMaxNumberData[2]){
                        newMatrix[newMatrixRow][newMatrixColumn] = initialMatrix[i][j];
                        newMatrixColumn++;
                    }
                }
                newMatrixColumn = 0;
                newMatrixRow++;
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {

        int[][] matrix = setLengthOfTwoDimensionalArrayMatrix();
        initializeMatrixByRandomNumbers(matrix);
        printMatrix(matrix);
        int[] mapWithMaxNumberData = findMaxValueFromMatrix(matrix);
        System.out.println(mapWithMaxNumberData[0]);
        matrix = deleteAsBombermanMaxValueFromMatrix(matrix, mapWithMaxNumberData);
        printMatrix(matrix);
    }
}
