package com.example.cazapatos;

public class Scores {
    String name;
    int score;

    public Scores(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ", " + score;
    }
}
