package Inheritances.Exercise;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float array[] = {super.getX(), super.getY(), this.z};
        return array;
    }

    public String toString() {
        return "Position: (" + super.getX() + "," + super.getY() + "," + this.z + ").";
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D(2.3f, 4.6f);
        System.out.println(point2D);
        Point3D point3D = new Point3D();
        Point2D point3D1 = new Point3D(1.0f, 2, 5);
        System.out.println(point3D);
        System.out.println(point3D1);
    }
}