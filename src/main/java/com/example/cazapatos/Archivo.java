package com.example.cazapatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {

    public void write(List<Scores> scores) {

        try {
            FileWriter fileWriter = new FileWriter("scores.txt");
            for (Scores score: scores) {
                fileWriter.write(score.toString() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Scores> read() {
        List<Scores> scoreList = new ArrayList<>();
        String nombre = "";
        int puntos;

        try {
            Scanner scanner = new Scanner(new File("scores.txt"));
            scanner.useDelimiter(",|\n");

            while (scanner.hasNext()) {
                nombre = scanner.next();
                puntos = scanner.nextInt();

                scoreList.add(new Scores(nombre, puntos));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scoreList;
    }
}
