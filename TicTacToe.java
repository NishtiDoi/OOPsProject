
import java.util.Scanner;

class TicTacToe {
    private static final int SIZE = 3;
    private char[][] board;

    public TicTacToe() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        return board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }

    private boolean makeMove(int row, int col, char symbol) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void playGameFromConsole() {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        while (true) {
            System.out.println("Current board:");
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (!makeMove(row, col, currentPlayer)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }
            if (checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }
}