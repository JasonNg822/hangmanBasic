import java.util.ArrayList;
import java.util.List;

public class GameLogic {

    public static int choice(int min, int max){
        String choose;
        int number;
        while (true){
            try {
                GameUI.print("Please enter a number " + min + " - " + max + ": ");
                choose = GameUI.input.nextLine();
                number = Integer.parseInt(choose);
                if (number <= max && number >= min){
                    break;
                }
                else{
                    GameUI.println("\nInvalid input, please enter a number " + min + " - " + max);
                }
            } catch (Exception e) {
                GameUI.println("\nInvalid input, please enter a number " + min + " - " + max);
            }
        }
        return number;
    }

    // change the word or sentence to a series of "_", if got symbol or number will display out the symbol or number 
    public static String hide_sentences (List <Character> used_letter, String word){
        List <String> hide_letters = new ArrayList<>();
        String display;
        char[] words = word.toCharArray(); // toCharArray() means change the String to an char array
        for (char letter : words){
            String string_letter = String.valueOf(letter); // change char to string because .contains only for String
            if (used_letter.contains(letter)){
                display = string_letter;
                hide_letters.add(display);
            }
            else if (!string_letter.matches("[A-Za-z]+")){ // if letter not a alphabet
                display = string_letter;
                hide_letters.add(display);
            }
            else { // if letter haven't guess by player
                display = "_";
                hide_letters.add(display);
            }
        }
        String hide_letter = String.join(",", hide_letters).replace(",", "");// convert the hide_letters array to String without ","
        return hide_letter;
    }

    // to get what letter player guess
    public static char letter() {
        char letter;
        while (true) { 
            try {
                GameUI.print("Guess a letter: ");
                // to change the letter player input to uppercase and only get the first letter if player input more than one letter.
                letter = GameUI.input.nextLine().toUpperCase().charAt(0);       
                if (String.valueOf(letter).matches("[A-Za-z]+")) { // .matches only can use on String
                    break;
                }
            } catch (Exception e) {
                GameUI.println("Invalid input.");
            }
        }
        return letter;
    }

    // to get how many time player guess wrong
    public static int number_of_guess_wrong(int number_of_guess_wrong, String word, char letter, List <Character> used_letter){
        String string_letter = String.valueOf(letter);
        if ((word.contains(string_letter)) || used_letter.contains(letter)){ // don't change number_of_guess_wrong if guess correct or guess before
            return number_of_guess_wrong;
        }
        else if (!word.contains(string_letter)){
            number_of_guess_wrong++;
        }
        return number_of_guess_wrong;
    }

    // check if win or not
    public static boolean basic_win_logic(List <Character> used_letter, String word, String name) {
        if (hide_sentences(used_letter, word).equals(word.trim())){  // check if the hide_sentences is all match with the word
            GameUI.display_win(name);
            return true;    
        }
        return false;
    }

    // to check is lose or not
    public static boolean basic_lose_logic(int number_of_guess_wrong, String word, String name){
        if (number_of_guess_wrong >= 6){ 
            GameUI.display_lose(name, word);
            GameUI.display_hangman(number_of_guess_wrong);
            return true;
        }
        else{
            return false;
        }
    }
}
