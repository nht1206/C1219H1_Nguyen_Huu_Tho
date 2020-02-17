package ArrayAndMethodInJava.Exercise;

public class CharacterFrequence {
    public static void main(String[] args) {
        String myString = "This is a string that i create to test this application.";
        char myChar = 't';
        int count = 0;
        for (int i = 0; i < myString.length(); i++){
            if (myChar == myString.charAt(i)){
                count++;
            }
        }
        System.out.println("The number of times the character appeared in the string is " + count);
    }
}
