package com.example.cazapatos;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    DatagramSocket socket;
    int intent = 0;
    List<Scores> scoreList = new ArrayList<>();
    List<Scores> ordenador = new ArrayList<>();

    //Instàciar el socket
    public void init(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void runServer() throws IOException {
        byte [] receivingData = new byte[1024];
        byte [] sendingData;
        InetAddress clientIP;
        int clientPort;

        /*ObjectOutputStream ooos = new ObjectOutputStream(this.s.getOutputStream());
        ObjectInputStream oois = new ObjectInputStream(this.s.getInputStream());

        this.getTopology();
        this.ooos.writeObject(getTopology());
        this.ooos.flush();*/

        while(true) {
            DatagramPacket packet = new DatagramPacket(receivingData,1024);
            socket.receive(packet);
            sendingData = processData(packet.getData(),packet.getLength());
            //Llegim el port i l'adreça del client per on se li ha d'enviar la resposta
            clientIP = packet.getAddress();
            clientPort = packet.getPort();
            packet = new DatagramPacket(sendingData,sendingData.length,clientIP,clientPort);
            socket.send(packet);
        }
    }

    /*private byte[] tranform(byte[] data, int lenght){
        int num = ByteBuffer.wrap(data).getInt(); //data és l'array de bytes
        byte[] resposta = ByteBuffer.allocate(4).putInt(num).array(); //num és un int

        return resposta;
    }*/

    //El server retorna al client el mateix missatge que li arriba però en majúscules
    private byte[] processData(byte[] data, int lenght) {

        String msg = new String(data,0,lenght);
        msg = msg.toUpperCase();

        String resultat = "";

        try {
            writeScore(msg);
            resultat = "Datos guardados!";
        } catch (IOException e) {
            e.printStackTrace();
            resultat = "Error al guardar los datos!";
        }
        intent++;

        //String resultat = "Inteto: " + intent + ", Resultat: " + secretNum.comprova(msg) + " -> ";
        return resultat.getBytes();

        //Imprimir el missatge rebut i retornar-lo
        //System.out.println(msg);
        //return msg.getBytes();
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.init(5555);
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeScore(String data) throws IOException {

        try {
            FileWriter fileWriter = new FileWriter("scores.txt", true);
            fileWriter.write(data+"\n");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        readScore();
    }

    public void readScore() {

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
    }

}
