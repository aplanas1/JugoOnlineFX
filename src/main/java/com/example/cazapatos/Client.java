package com.example.cazapatos;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends Thread{
    //InetAddress serverIP;
    private String hostname;
    private int port;
    private boolean acabat = false;
    DatagramSocket socket;
    Scanner sc;
    String nom;

    private InputStream is;
    private OutputStream os;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    List<Scores> scoreList = new ArrayList<>();

    List<Scores> scores = new ArrayList<>();
    Scores score;

    String nombre;
    int puntuacion;

    public Client(String host, int port) {
        this.hostname = host;
        this.port = port;
    }

    public void CallServer(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    /*public void init(String host, int port) throws SocketException, UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }*/

    public void runClient(String data) throws IOException {
        Socket socket;
        /*byte [] receivedData = new byte[1024];
        byte [] sendingData;*/

        //sendingData = data.getBytes();

        try {
            socket = new Socket(InetAddress.getByName(hostname), port);
            os = socket.getOutputStream();
            output = new ObjectOutputStream(os);
            is = socket.getInputStream();
            input = new ObjectInputStream(is);

            while (!acabat) {
                /*Jugador jugador = new Jugador("joel", 100);*/
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

        /*while (mustContinue(sendingData)) {
            DatagramPacket packet = new DatagramPacket(sendingData,sendingData.length,serverIP,serverPort);
            socket.send(packet);
            packet = new DatagramPacket(receivedData,1024);
            socket.receive(packet);
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }*/

    }

    public List<Scores> getListado() {
        return scores;
    }

    public void setPlayers(List<Scores> scores) {
        this.scores = scores;
    }

    /*
    //Resta de conversa que se li envia al server
    private byte[] getDataToRequest(byte[] data, int length) {
        String rebut = new String(data,0, length);
        //Imprimeix el nom del client + el que es reb del server i demana més dades
        System.out.print(rebut);
        String msg = sc.nextLine();
        return msg.getBytes();
    }

    //primer missatge que se li envia al server
    private byte[] getFirstRequest() {
        System.out.println("Entra el teu numero: ");
        nom = sc.nextLine();
        return nom.getBytes();
    }

    //Si se li diu adeu al server el client es desconnecta
    private boolean mustContinue(byte [] data) {
        String msg = new String(data).toLowerCase();
        return !msg.equals("adeu");
    }

    public static void main(String[] args) {
        Client client = new Client("localhost",5555);
        try {
            client.runClient("AAA,24");
        } catch (IOException e) {
            e.getStackTrace();
        }

    }*/

}
