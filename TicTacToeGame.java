// TicTacToeGame.java
import java.util.*;

public class TicTacToeGame {
    private Board board;
    private String currentPlayer;

    public TicTacToeGame() {
        this.board = new Board();
        this.currentPlayer = "X";
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String winner = null;

        System.out.println("Welcome to Tic Tac Toe!");
        board.print();

        while (winner == null) {
            System.out.println(currentPlayer + "'s turn. Enter slot number (1-9):");
            int input;

            try {
                input = scanner.nextInt();
                if (!board.placeMove(input, currentPlayer)) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            board.print();
            winner = board.checkWinner();

            if (winner == null) {
                switchPlayer();
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + " wins!");
        }

        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }
}

