import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the game menu:");
        System.out.println("1. Hangman");
        System.out.println("2. Tic-Tac-Toe");
        System.out.print("Enter your choice (1 or 2): ");

        choice = keyboard.nextInt();
        keyboard.nextLine(); // Consume newline

        if (choice == 1) {
            HangmanGame hangmanGame = new HangmanGame();
            hangmanGame.play();
        } else if (choice == 2) {
            TicTacToeGame ticTacToeGame = new TicTacToeGame();
            ticTacToeGame.play();
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
        keyboard.close();
    }
}
