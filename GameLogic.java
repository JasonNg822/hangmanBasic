import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {

    private static final Scanner input = new Scanner(System.in);

    public static int categorys () {
        println("Category: ");
        println("1. Fruit");
        println("2. Animal");
        println("3. Country");
        println("4. Sport");
        String category;
        while (true) { 
            try {
                print("Please enter a number 1 or 2 or 3 or 4: ");
                category = input.nextLine();
                if (!category.equals("1") && !category.equals("2") && !category.equals("3") && !category.equals("4")){
                    continue;
                }
                else{
                    break;
                }
            } catch (Exception e) {
                println("Invalid input.");
            }
        }
        return Integer.parseInt(category);
    }

    public static int level () {
        println("\nLevel: ");
        println("1. Easy");
        println("2. Medium");
        println("3. Hard");
        String category;
        while (true) { 
            try {
                print("Please enter a number 1 or 2 or 3: ");
                category = input.nextLine();
                if (!category.equals("1") && !category.equals("2") && !category.equals("3")){
                    continue;
                }
                else{
                    break;
                }
            } catch (Exception e) {
                println("Invalid input.");
            }
        }
        return Integer.parseInt(category);
    }

    // to get what user guess
    public static char letter() {
        char letter;
        while (true) { 
            try {
                print("Guess a letter: ");
                // to change the letter user input to uppercase and only get the first letter if user input more than one letter.
                letter = input.nextLine().toUpperCase().charAt(0);       
                if (!String.valueOf(letter).matches("[A-Za-z]+")) {
                    continue;
                }
                else {
                    break;
                }
            } catch (Exception e) {
                println("Invalid input.");
            }
        }
        return letter;
    }

    // to record the player guess wrong how many times
    public static int number_of_guess_wrong(int number_of_guess_wrong, String word, char letter, List <Character> used_letter){
        String string_letter = String.valueOf(letter);
        if ((!word.contains(string_letter)) && used_letter.contains(letter)){
            return number_of_guess_wrong;
        }
        else if (!word.contains(string_letter)){
            number_of_guess_wrong++;
        }
        return number_of_guess_wrong;
    }

    // change the word or sentence to a series of "_", if got symbol or number will display out the symbol or number 
    public static String hide_sentence (List <Character> used_letter, String word){
        List <String> hide_letters = new ArrayList<>();
        String display;
        char[] words = word.toCharArray();
        for (char letter : words){
            String string_letter = String.valueOf(letter);
            if (used_letter.contains(letter)){
                display = string_letter;
                hide_letters.add(display);
            }
            else if (!string_letter.matches("[A-Za-z]+")){
                display = string_letter;
                hide_letters.add(display);
            }
            else {
                display = "_";
                hide_letters.add(display);
            }
        }
        String hide_letter = String.join(",", hide_letters).replace(",", "");
        return hide_letter;
    }

    // to check is lose or not
    public static boolean basic_lose_logic(int number_of_guess_wrong, String word, boolean game_end){
        if (number_of_guess_wrong >= 6){
            return game_end = true;
        }
        else{
            return game_end = false;
        }
    }

    public static void println(String a){
        System.out.println(a);
    }

    public static void print(String a){
        System.out.print(a);
    }
    
}
