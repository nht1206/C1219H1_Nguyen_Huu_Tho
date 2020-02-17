package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class DeletingElement {
    public static void main(String[] args) {
        int n = 5;
        int[] array = new int[20];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            System.out.println("Enter the element " + i + " : ");
            array[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println("\nEnter the position : ");
        int pos = input.nextInt();

        for (int i = pos; i < n; i++){
            array[i] = array[i + 1];
        }
        n--;
        for (int i = 0; i < n; i++){
            System.out.print(array[i] + "\t");
        }
    }
}
