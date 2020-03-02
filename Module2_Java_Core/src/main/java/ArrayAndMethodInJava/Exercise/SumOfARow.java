package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class SumOfARow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = 5, col = 5;
        int[][] array = new int[row][col];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("Enter the row you need to calculate: ");
        int mRow = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < array[mRow].length; i++){
            sum += array[mRow][i];
        }
        System.out.println("The sum of that row is " + sum);
    }
}
