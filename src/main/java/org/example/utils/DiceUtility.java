package org.example.utils;

public class DiceUtility {
    public static int roll(int numberOfDices) {
        int min = 1;
        int max = numberOfDices * 6;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}


// Math.random() -> [0,1) Inclusive 0 and exclusive 1

/*

min = 1
max = 6

 0.6 * 6 + 1 => 4.6 => 4
 0.1 * 6 + 1 => 1.6 => 1
 0 * 6 + 1 => 1
 0.25 * 6 + 1 => 2

min = 1
max = 12

0.2 * 12 + 1 => 4
0.9 * 12 + 1 => 12
0.99999 * 12 + 1 =>

 */