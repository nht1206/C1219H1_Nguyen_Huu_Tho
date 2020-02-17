package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class InsertingElementIntoArray {
    public static void main(String[] args) {
        int n = 5;
        int[] array = new int[20];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            System.out.println("Enter the element " + i + " : ");
            array[i] = input.nextInt();
        }
        System.out.println("Enter the value to insert: ");
        int value = input.nextInt();
        System.out.println("Enter the position : ");
        int pos = input.nextInt();
        for (int i = n; i > pos; i--){
            array[i] = array[i - 1];
        }
        array[pos] = value;
        for (int i = 0; i < n; i++){
            System.out.print(array[i] + "\t");
        }
    }
}
