import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class TestPuzzleJava{
    public static void main(String[] args) { 
    PuzzleJava generator = new PuzzleJava();
    ArrayList<Integer> randomTenRolls = generator.getTenRolls();
    System.out.println(randomTenRolls);
    }
}





