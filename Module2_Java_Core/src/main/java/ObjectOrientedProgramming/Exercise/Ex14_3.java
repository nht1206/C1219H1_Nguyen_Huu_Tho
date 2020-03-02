package ObjectOrientedProgramming.Exercise;

public class Ex14_3 {
    public static void main(String[] args) {
        Fan fan1 = new Fan(Fan.FAST, true, 10, "Yellow");
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        System.out.println(fan1);
        System.out.println(fan2);
    }
}
