import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class HangmanGame extends Game {
    private List<String> words;
    private String word;
    private List<Character> guesses;
    private int wrongCount;

    public HangmanGame() throws FileNotFoundException {
        words = loadWordsFromFile("word2.txt");
        guesses = new ArrayList<>();
        wrongCount = 0;
        word = getRandomWord();
    }

    private List<String> loadWordsFromFile(String filePath) throws FileNotFoundException {
        List<String> wordList = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNext()) {
            wordList.add(sc.nextLine());
        }
        return wordList;
    }

    private String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    @Override
    // OOP Concept: Polymorphism
    void play() {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            HangedMan(wrongCount);
            if (wrongCount >= 6) {
                System.out.println("YOU LOST");
                System.out.println("Right word is: " + word);
                break;
            }

            printword(word, guesses);
            if (!getGuess(keyboard, word, guesses)) {
                wrongCount++;
            }
            if (printword(word, guesses)) {
                System.out.println("YOU WIN");
                break;
            }
            System.out.println("Please enter your guess for word");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("YOU WIN");
                break;
            } else {
                System.out.println("TRY AGAIN");
            }
        }
    }

    // OOP Concept: Encapsulation
    private void HangedMan(int wrongCount) {
        System.out.println("-------");
        System.out.println(" |     ");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }
        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else
                System.out.println("");
        }
        if (wrongCount >= 4) {
            System.out.println(" |");
        }
        if (wrongCount >= 5) {
            System.out.print("/");
            if (wrongCount >= 6) {
                System.out.println(" \\ ");
            } else
                System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }

    // OOP Concept: Encapsulation
    private boolean getGuess(Scanner keyboard, String word, List<Character> guesses) {
        System.out.println("Please enter your guess for letter");
        String nxt = keyboard.nextLine();
        guesses.add(nxt.charAt(0));
        return word.contains(nxt);
    }

    // OOP Concept: Encapsulation
    private boolean printword(String word, List<Character> guesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (guesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else
                System.out.print("-");
        }
        System.out.println();
        return (correctCount == word.length());
    }
}