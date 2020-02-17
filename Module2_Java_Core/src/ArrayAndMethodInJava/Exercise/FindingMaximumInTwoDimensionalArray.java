package ArrayAndMethodInJava.Exercise;

public class FindingMaximumInTwoDimensionalArray {
    public static void main(String[] args) {
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
        int max = array[0][0];
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max){
                    max = array[i][j];
                }
            }
        }
        System.out.println("The maximum element is: " + max);
    }
}
