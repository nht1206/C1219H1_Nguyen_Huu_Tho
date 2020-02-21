package ObjectOrientedProgramming.Exercise;

import java.util.Scanner;

public class Ex14_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The quadratic equation has a root : " + quadraticEquation.getRoot1());
        } else if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("Root 1 : " + quadraticEquation.getRoot1());
            System.out.println("Root 2 : " + quadraticEquation.getRoot2());
        } else {
            System.out.println("The equation has no root");
        }
    }
}
