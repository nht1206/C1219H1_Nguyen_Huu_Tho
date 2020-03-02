package ProgramingLanguageJava.Exercise;

public class ShowingPrimes {
    public static void main(String[] args) {
        System.out.println("The primes less than 100 is : ");
        for (int i = 0; i < 100; i++) {
            if (CheckingPrimeNumber.isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("The first 20 primes is : ");
        int count = 0;
        int i = 0;
        while (count < 20) {
            if (CheckingPrimeNumber.isPrimeNumber(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }
}
