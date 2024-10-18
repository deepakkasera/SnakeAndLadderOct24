package org.example.models;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public void getMessage() {
        System.out.println("Yay!! You encountered a Ladder.");
    }


    public void getString() {
        System.out.print("L(" + getEnd() + ")");
    }

}
