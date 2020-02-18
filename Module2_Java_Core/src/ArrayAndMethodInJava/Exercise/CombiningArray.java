package ArrayAndMethodInJava.Exercise;

public class CombiningArray {
    public static void main(String[] args) {
        int n1 = 5;
        int[] array1 = {1, 2, 5, 6, 7};
        int n2 = 5;
        int[] array2 = {8, 0, 3, 4, 9};
        int n3 = n1 + n2;
        int[] array3 = new int[n3];
        for (int i = 0; i < n1; i++){
            array3[i] = array1[i];
        }
        for (int i = n1; i < n3; i++){
            array3[i] = array2[i - n2];
        }
        for (int i = 0; i < n3; i++){
            System.out.print(array3[i] + "\t");
        }
    }
}
