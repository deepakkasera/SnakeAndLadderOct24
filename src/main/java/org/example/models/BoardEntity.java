package org.example.models;

public abstract class BoardEntity {
    private int start;
    private int end;

    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public abstract void getMessage();

    public abstract void getString();

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
