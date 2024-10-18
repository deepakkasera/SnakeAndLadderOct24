package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int dimension;
    private int cellCount;
    private Map<Integer, BoardEntity> boardEntityMap;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cellCount = dimension * dimension;
        boardEntityMap = new HashMap<>();

        //Add n number of Snakes and Ladders in the HashMap (Where n is the dimension of the board).
        addSnakesAndLaddersToTheBoard();
    }


    //Snake -> s, e => s > e
    //Ladder -> s, e => e > s

    private void addSnakesAndLaddersToTheBoard() {
        for (int i = 0; i < this.dimension; i++) {
            addSnake();
            addLadder();
        }
    }

    private void addSnake() {
        int min = 2;
        int max = cellCount - 1; // 99

        //Snake
        int start = (int) Math.floor(Math.random() * (max - min + 1) + min); // 98*0.2 + 2 => 21
        max = start - 1; // 20
        int end = (int) Math.floor(Math.random() * (max - min + 1) + min); // 0.6 * 19 + 2 => 13

        if (!hasSnakeOrLadder(start)) {
            boardEntityMap.put(start, new Snake(start, end));
        }
    }

    private void addLadder() {
        int min = 2;
        int max = cellCount - 1;

        int end = (int) Math.floor(Math.random() * (max - min + 1) + min);
        max = end - 1;
        int start = (int) Math.floor(Math.random() * (max - min + 1) + min);
        if (!hasSnakeOrLadder(start)) {
            boardEntityMap.put(start, new Ladder(start, end));
        }
    }

    public boolean hasSnakeOrLadder(int cellIndex) {
        return boardEntityMap.containsKey(cellIndex);
    }

    public void displayBoard() {
        for (int i = cellCount; i > 0; i--) {
            System.out.print(i + " ");
            if (hasSnakeOrLadder(i)) {
                boardEntityMap.get(i).getString();
            } else {
                System.out.print("     ");
            }

            if (i != 100 && i % 10 == 0) System.out.println();
        }

        System.out.println();
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }

    public Map<Integer, BoardEntity> getBoardEntityMap() {
        return boardEntityMap;
    }

    public void setBoardEntityMap(Map<Integer, BoardEntity> boardEntityMap) {
        this.boardEntityMap = boardEntityMap;
    }
}
