import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// to coordinate the overall game application functionality, (single player, computer random generate word)
public class HangmanBasic extends GameUI{

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        boolean continues = true;
        char letter;
        String ans;

        while (continues == true) {
            // a variable to record number of user guess wrong
            int number_of_guess_wrong = 0;
            List <Character> used_letter = new ArrayList<>();
            println("\n===== Welcome to Hangman game! =====");
            int category = GameLogic.categorys();
            int level = GameLogic.level();
            String word = WordLoader.get_word(category, level).toUpperCase().trim();
            boolean game_end = false;

            while (game_end == false) { 
                footer();
                display_hangman(number_of_guess_wrong);
                // print out "Word:" and _ or letter that user guess correct
                hide_sentence(used_letter, word);
                // print out left how many time user guess wrong like "Incorrect Guesses: 3/6"
                incorrect(number_of_guess_wrong);
                println("Used Letters: " + used_letters(used_letter));
                footer();
                // the letter user guess
                letter = GameLogic.letter();
                number_of_guess_wrong = GameLogic.number_of_guess_wrong(number_of_guess_wrong, word, letter, used_letter);
                if (used_letter.contains(letter)){
                    continue;
                }
                else{
                    used_letter.add(letter);
                }
                footer();
                // check if win or not
                if (GameLogic.hide_sentences(used_letter, word).equals(word.trim())){
                    display_win(number_of_guess_wrong);
                    game_end = true;
                }
                // check if lose or not
                if (GameLogic.basic_lose_logic(number_of_guess_wrong, word, game_end)){
                    display_lose(word);
                    display_hangman(number_of_guess_wrong);
                    game_end = true;
                }
            }
            do {
                print("\nYou want to continue for next game? (y/n): "); 
                ans = input.nextLine();
            } while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n"));
            if (ans.equalsIgnoreCase("n")){
                println("");
                continues = false;
            }
        }
        input.close();
    }

    // to convert list to String
    public static String used_letters(List <Character> used_letter) {
        List <String> usedLetters = new ArrayList<>();
        for (char letter : used_letter) {
            usedLetters.add(String.valueOf(letter));
        }
        return String.join(", ", usedLetters);
    }
}
