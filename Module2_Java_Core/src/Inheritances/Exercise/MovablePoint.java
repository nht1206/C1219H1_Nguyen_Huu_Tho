package Inheritances.Exercise;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {

    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float arr[] = {this.xSpeed,this.ySpeed};
        return arr;
    }

    public String toString() {
        return "( " + super.getX() + ", " + super.getY() + "), speed = ( " + this.xSpeed + ", " + this.ySpeed + ").";
    }

    public MovablePoint move() {
        super.setX(super.getX()+this.xSpeed);
        super.setY(super.getY()+this.ySpeed);
        return this;
    }

    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(1,2,3,4);
        System.out.println(movablePoint.toString());
        System.out.println(movablePoint.move().toString());

    }
}
