package com.example.cazapatos;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client extends Thread{

    private String hostname;
    private int port;
    private boolean acabat = false;
    private InputStream is;
    private OutputStream os;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    List<Scores> scores = new ArrayList<>();
    Scores score;

    String nombre;
    int puntuacion;

    public Client(String host, int port) {
        this.hostname = host;
        this.port = port;
    }

    public void callServer(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    @Override
    public void run() {
        Socket socket;

        try {
            socket = new Socket(InetAddress.getByName(hostname), port);
            os = socket.getOutputStream();
            output = new ObjectOutputStream(os);
            is = socket.getInputStream();
            input = new ObjectInputStream(is);

            while (!acabat) {
                score = new Scores(nombre, puntuacion);
                output.writeObject(score);
                output.flush();

                scores = (List<Scores>) input.readObject();
                setPlayers(scores);
                acabat = true;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            output.close();
            input.close();
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Scores> getListado() {
        return scores;
    }

    public void setPlayers(List<Scores> scores) {
        this.scores = scores;
    }
}