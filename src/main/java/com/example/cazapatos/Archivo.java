package com.example.cazapatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {

    public void Escribir(List<Scores> scores) {

        try {
            FileWriter fileWriter = new FileWriter("scores.txt", true);
            for (Scores score: scores) {
                fileWriter.write(score.toString() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Scores> Leer() {
        List<Scores> scoreList = new ArrayList<>();
        List<Scores> ordenador = new ArrayList<>();
        String nombre = "";
        int puntos;

        try {
            Scanner scanner = new Scanner(new File("scores.txt"));
            scanner.useDelimiter(",|\n");

            while (scanner.hasNext()) {
                nombre = scanner.next();
                puntos = scanner.nextInt();
                //scoreList.add(new Scores(nombre, puntos));
                ordenador.add(new Scores(nombre, puntos));
            }

            while(ordenador.size() > 0){
                int posNotaMax = 0;
                for (int i = 0; i < ordenador.size(); i++) {
                    if(ordenador.get(i).score > ordenador.get(posNotaMax).score){
                        posNotaMax = i;
                    }
                }
                scoreList.add(ordenador.get(posNotaMax));
                ordenador.remove(posNotaMax);
            }

            for (Scores s: scoreList) {
                System.out.println(s.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scoreList;
    }
}
