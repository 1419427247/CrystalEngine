package pers.crystal.engine.utility;

import java.io.IOException;
import java.net.*;

public class CEServer {
    public int port;

    private DatagramSocket datagramSocket = null;

    public CEServer(int port) {
        this.port = port;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    public void SendMessage(byte[] message,InetAddress inetAddress){
        DatagramPacket datagramPacket = new DatagramPacket(message,message.length,inetAddress,port);
        try {
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Close() {
        datagramSocket.close();
    }

}