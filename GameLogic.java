import java.util.ArrayList;
import java.util.List;

public class GameLogic extends HangmanBasic{

    public static int choice(int min, int max){
        String choose;
        int number;
        while (true){
            try {
                print("Please enter a number " + min + " - " + max + ":");
                choose = input.nextLine();
                number = Integer.parseInt(choose);
                if (number <= max && number >= min){
                    break;
                }
                else{
                    println("Invalid input, please enter a number " + min + " - " + max);
                }
            } catch (Exception e) {
                println("Invalid input, please enter a number " + min + " - " + max);
            }
        }
        return number;
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
    public static String hide_sentences (List <Character> used_letter, String word){
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
}
