package com.example.cazapatos;

import java.io.Serializable;

public class Scores implements Serializable {
    String name;
    int score;

    public Scores(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "," + score;
    }
}
