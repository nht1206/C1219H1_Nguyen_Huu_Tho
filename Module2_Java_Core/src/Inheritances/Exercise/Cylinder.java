package Inheritances.Exercise;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {

    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 2*super.getArea() + super.getPerimeter()*this.height;
    }

    public double getVolume() {
        return super.getArea()*this.height;
    }

    public String toString() {
        return "A cylinder with color: " + super.getColor()+ " and radius: " + super.getRadius()+ " , height: " + this.height + " area: " + this.getArea()+ " volume: "+this.getVolume();
    }

    public static void main(String[] args) {

        Circle circle = new Circle();
        System.out.println(circle);

        Circle circle1 = new Circle("yellow", 2.0);
        System.out.println(circle1);

        Circle cylinder = new Cylinder();
        System.out.println(cylinder);

        Cylinder cylinder1 = new Cylinder("yellow", 2.5 , 4.0);
        System.out.println(cylinder1);
    }
}