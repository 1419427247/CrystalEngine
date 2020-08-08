package pers.crystal.engine.utility.net;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class CESocket implements Runnable {

    public static final int DATA_MAX_LENGTH = 64;
    private CECommand command = new CECommand();
    private DatagramSocket datagramSocket = null;

    public CESocket(int port) {
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    public CESocket(int port, InetAddress inetAddress) {
        try {
            datagramSocket = new DatagramSocket(port, inetAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!datagramSocket.isClosed()) {
            byte[] buff = new byte[DATA_MAX_LENGTH];
            try {
                DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
                datagramSocket.receive(datagramPacket);
                OnReceive(datagramPacket);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void OnReceive(DatagramPacket datagramPacket) {
        int offset = 0;
        byte[] bytes = datagramPacket.getData();
        while (offset < bytes.length) {
            byte type = bytes[offset];
            int length = (int) (((bytes[offset + 1] & 0xFF) << 24) | ((bytes[offset + 2] & 0xFF) << 16)
                    | ((bytes[offset + 3] & 0xFF) << 8) | (bytes[offset + 4] & 0xFF));
            if (type == 0 || length == 0) {
                break;
            }
            CEMessage massage = new CEMessage();
            byte[] args = Arrays.copyOfRange(bytes, offset + 5, offset + 5 + length);

            for (int i = 0; i < args.length; i++) {
                massage.bytes.add(args[i]);
            }

            command.Execute((String) massage.Get(), datagramPacket.getAddress(), massage);
            offset += length + 5;
            if (bytes.length - offset < 5) {
                break;
            }
        }
    }

    public void RegisterInstruction(String key, CEInstruction instruction) {
        command.RegisterInstruction(key, instruction);
    }

    public void SendMessage(CEMessage message, InetAddress inetAddress, int port) {
        if (message.size() > DATA_MAX_LENGTH) {
            throw new RuntimeException();
        }
        byte[] bytes = message.GetAllBytes();
        
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, port);
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