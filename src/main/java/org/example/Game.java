package org.example;

import org.example.models.Board;
import org.example.models.BoardEntity;
import org.example.models.Player;
import org.example.utils.DiceUtility;

import java.util.*;

public class Game {
    private Board board;
    private Queue<Player> players;
    private List<Player> winners;
    private int numberOfDices;
    private int dimension;

    public Game(int dimension, int numberOfDices, Queue<Player> players) {
        this.dimension = dimension;
        this.numberOfDices = numberOfDices;
        this.players = players;
        this.winners = new ArrayList<>();
        this.board = new Board(dimension);
    }

    public void launch() {
        this.board.displayBoard();

        while (players.size() > 1) {
            Player currentPlayer = players.poll();

            System.out.println("It is " + currentPlayer.getUsername() + "'s turn.");
            System.out.println("Press 'r' to roll the dice.");

            Scanner scanner = new Scanner(System.in);
            char input = scanner.next().charAt(0);

            currentPlayer.makeMove(this.board, numberOfDices);

            //Check if current player has WON the game or not.
            if (currentPlayer.getCurrentPosition() == board.getCellCount()) {
                System.out.println(currentPlayer.getUsername() + " has WON the game. Congratulations!!");
                winners.add(currentPlayer);
            } else {
                players.add(currentPlayer);
            }
        }
    }
}
