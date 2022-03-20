package com.example.cazapatos;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ThreadSevidorObjJugador implements Runnable{

    private Socket socket;
    private OutputStream os;
    private ObjectOutputStream output;
    private InputStream is;
    private ObjectInputStream input;
    private boolean acabat = false;
    Archivo archivo;

    List<Scores> scores = new ArrayList<>();


    public ThreadSevidorObjJugador(Socket clientSocket) {
        this.socket = clientSocket;
        archivo = new Archivo();
        try {
            is = clientSocket.getInputStream();
            input = new ObjectInputStream(is);
            os = clientSocket.getOutputStream();
            output = new ObjectOutputStream(os);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!acabat) {
                scores = archivo.Leer();
                //LLegim l'objecte Jugador del stream input
                Scores score = (Scores) input.readObject();
                scores.add(score);

                //comprobamos lo que recibe el servidor
                System.out.println(score.name + " " + score.score);

                archivo.Escribir(scores);

                //tornem la llista al client per l'output
                output.writeObject(archivo.Leer());
                output.flush();

                acabat = true;
            }
        }catch (ClassNotFoundException | IOException e) {
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
}
