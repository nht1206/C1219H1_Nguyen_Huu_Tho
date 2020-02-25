package Inheritances.Exercise;

public class Circle {
    private String color = "green";
    private double radius = 1.0;

    public Circle() {

    }

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public String toString() {
        return "A Circle with color: " + this.color + " and radius: " + this.radius + " , area:" + this.getArea();
    }
}