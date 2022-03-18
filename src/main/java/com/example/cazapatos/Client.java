package com.example.cazapatos;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;
    Scanner sc;
    String nom;

    public Client() {
        sc = new Scanner(System.in);
    }

    public void init(String host, int port) throws SocketException, UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient(String data) throws IOException {
        byte [] receivedData = new byte[1024];
        byte [] sendingData;

        sendingData = data.getBytes();
        while (mustContinue(sendingData)) {
            DatagramPacket packet = new DatagramPacket(sendingData,sendingData.length,serverIP,serverPort);
            socket.send(packet);
            packet = new DatagramPacket(receivedData,1024);
            socket.receive(packet);
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }

    }

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
        Client client = new Client();
        try {
            client.init("localhost",5555);
            client.runClient("AAA,24");
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

}
