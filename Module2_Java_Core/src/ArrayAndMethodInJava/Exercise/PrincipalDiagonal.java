package ArrayAndMethodInJava.Exercise;

public class PrincipalDiagonal {
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
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i][i];
        }
        System.out.println("The sum of principal diagonal : " + sum);
    }
}
