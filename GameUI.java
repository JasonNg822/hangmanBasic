import java.util.List;

public class GameUI {

    public static void footer (){
        println("------------------------------------");
    }

    public static void categorys () {
        println("Category: ");
        println("1. Fruit");
        println("2. Animal");
        println("3. Country");
        println("4. Sport");
    }

    public static void level () {
        println("\nLevel: ");
        println("1. Easy");
        println("2. Medium");
        println("3. Hard");
    }

    public static void hide_sentence (List <Character> used_letter, String word){
        print("Word:");
        println(GameLogic.hide_sentences(used_letter, word));
    }

    public static void incorrect (int number_of_guess_wrong){
        println("Incorrect Guesses: " + number_of_guess_wrong + "/6");
    }

    public static void display_lose (String word){
        println("===== Game Over! =====");
        println("Sorry, you LOST! The word was: " + word);
    }

    public static void display_win (int number_of_guess_wrong){
        println("===== Game Over! =====");
        println("Congratulations, you have WON!");
    }

    // display the part of hangman figure as a tally mark  
    public static void display_hangman (int number_of_guess_wrong){
        switch (number_of_guess_wrong) {
            case 0:
                println("+---+");
                println("|   |");
                println("|   ");
                println("|   ");
                println("|   ");
                println("|   ");
                println("=======");
                break;
            case 1:
                println("+---+");
                println("|   |");
                println("|   O");
                println("|   ");
                println("|   ");
                println("|   ");
                println("=======");
                break;
            case 2:
                println("+---+");
                println("|   |");
                println("|   O");
                println("|   |");
                println("|   ");
                println("|   ");
                println("=======");
                break;
            case 3:
                println("+---+");
                println("|   |");
                println("|   O");
                println("|  /|");
                println("|   ");
                println("|   ");
                println("=======");
                break;
            case 4:
                println("+---+");
                println("|   |");
                println("|   O");
                println("|  /|\\");
                println("|   ");
                println("|   ");
                println("=======");
                break;
            case 5:
                println("+---+");
                println("|   |");
                println("|   O");
                println("|  /|\\");
                println("|  /");
                println("|   ");
                println("=======");
                break;
            default:
                println("+---+");
                println("|   |");
                println("|   O");
                println("|  /|\\");
                println("|  / \\");
                println("|   ");
                println("=======");
                break;
        }
    }

    public static void println(String a){
        System.out.println(a);
    }

    public static void print(String a){
        System.out.print(a);
    }
}
