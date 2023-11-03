
class TicTacToeGame extends Game {
    private TicTacToe ticTacToe;

    public TicTacToeGame() {
        ticTacToe = new TicTacToe();
    }

    @Override
    // OOP Concept: Polymorphism
    void play() {
        System.out.println("Playing Tic-Tac-Toe:");
        ticTacToe.playGameFromConsole();
    }
}