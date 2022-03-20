package com.example.cazapatos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRatanoid {
    private int port;

    public ServerRatanoid(int port) {
        this.port = port;
    }

    public void listen() {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            while(true) { //esperar connexió del client i llançar thread
                clientSocket = serverSocket.accept();
                //Llançar Thread per establir la comunicació
                ThreadSevidorObjJugador FilServidor = new ThreadSevidorObjJugador(clientSocket);
                Thread client = new Thread(FilServidor);
                client.start();
            }
        } catch (IOException ex) {
        }
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerRatanoid server = new ServerRatanoid(5557);
        server.listen();
    }
}
