package Inheritances.Exercise;

import Inheritances.Practice.Shape;

import java.util.Scanner;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {

    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double p = (side1 + side2 + side3) / 2;
        return Math.pow((p * (p - side1) * (p - side2) * (p - side3)), 0.5);
    }

    public double getPerimeter() {
        return (side1 + side2 + side3);
    }

    @Override
    public String toString() {
        return "A Triangle with perimeter: " + this.getPerimeter() + " area: " + this.getArea() + " and color: " + super.getColor();
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side1: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side3: ");
        double side3 = input.nextDouble();
        String color = "Green";

        triangle.setSide1(side1);
        triangle.setSide2(side2);
        triangle.setSide3(side3);
        triangle.setColor(color);

        System.out.println(triangle.toString());


    }
}
