import Java.Util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class PuzzleJava {
    //Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive. 
    public static int[] getTenRolls(){
        int[] randomTen = new int[10];
        Random randomnum= new Random();
        for (int i = 0; i < randomTen.length; i++){
            randomTen[i] = randomnum.nextInt();          
        }
        return randomTen;
    }

    public static void getRandomLetter(){
        ArrayList<Character> letters = new ArrayList<Character>();
        for (char i = 'a'; i <= 'z'; i++){
            letters.add(i);
        }

    }

    public static String generatePassword(){
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char i = 'a'; i <= 'z'; i++){
            letters.add(i);
        }
        for (int i = 0; i<8; i++) {
            randomCharArr.add(letters.get(i));
    }
        StringBuilder randomStr = new StringBuilder();
        for (char randomChar : randomCharArr) {
            randomStr.append(randomChar);
        }
        return randomStr.toString();
    }

    public static String[] getNewPasswordSet() {
        String[] newPassword = new String[8];
        for (int i=0; i<8; i++) {
            newPassword[i] = randomString();
        }
        return newPassword;
    
}



