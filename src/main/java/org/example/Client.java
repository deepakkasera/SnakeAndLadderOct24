package org.example;

import org.example.models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
    public static void main(String[] args) {
        int dimension = 10;
        int numberOfDices = 1;

        Player p1 = new Player("Smit", 1);
        Player p2 = new Player("Ashutosh", 1);
        Player p3 = new Player("Sharath", 1);

        Queue<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        Game game = new Game(dimension, numberOfDices, players);

        game.launch();
    }
}
