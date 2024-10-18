package org.example.models;

public class Snake extends BoardEntity {

    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public void getMessage() {
        System.out.println("Oops!! You encountered a Snake.");
    }

    public void getString() {
        System.out.print("S(" + getEnd() + ")");
    }
}
