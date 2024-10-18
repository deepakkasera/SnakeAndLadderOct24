package org.example.models;

import org.example.utils.DiceUtility;

public class Player {
    private String username;
    private int currentPosition;

    public Player(String username, int currentPosition) {
        this.username = username;
        this.currentPosition = currentPosition;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void makeMove(Board board, int numberOfDices) {
        int currentPosition = this.currentPosition;

        //Roll the dice.
        int dice = DiceUtility.roll(numberOfDices);
        System.out.println("Got " + dice + " on dice.");

        int finalPosition = currentPosition + dice;

        //Check if there's a Snake or a Ladder at finalPosition.
        if (finalPosition <= board.getCellCount()) {
            if (board.hasSnakeOrLadder(finalPosition)) {
                BoardEntity boardEntity = board.getBoardEntityMap().get(finalPosition);
                boardEntity.getMessage();
                finalPosition = boardEntity.getEnd();
            }

            System.out.println(this.username + " is making a move to " + finalPosition);
        } else {
            //Skipping the turn.
            System.out.println("Please try again in the next turn.");
            finalPosition = currentPosition;
        }

        this.setCurrentPosition(finalPosition);
    }
}
