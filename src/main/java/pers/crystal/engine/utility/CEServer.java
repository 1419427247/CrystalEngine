package pers.crystal.engine.utility;

import java.io.IOException;
import java.net.*;
import java.util.Stack;

public class CEServer implements Runnable {

    private final int DATA_MAX_LENGTH = 4096;

    public int port;
    private DatagramSocket datagramSocket = null;
    private Stack<byte[]> stack = new Stack<byte[]>();

    public CEServer(int port) {
        this.port = port;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        byte[] buff = new byte[DATA_MAX_LENGTH];
        DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
        while (datagramSocket.isClosed()) {
            try {
                datagramSocket.receive(datagramPacket);
                datagramPacket.getData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] GetData() {
        return stack.pop();
    }

    public void SendMessage(byte[] message, InetAddress inetAddress) {
        DatagramPacket datagramPacket = new DatagramPacket(message, message.length, inetAddress, port);
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