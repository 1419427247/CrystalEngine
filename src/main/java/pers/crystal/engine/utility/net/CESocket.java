package pers.crystal.engine.utility.net;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

import pers.crystal.engine.utility.CECommand;
import pers.crystal.engine.utility.CEInstruction;

public class CESocket implements Runnable {

    public static final int DATA_MAX_LENGTH = 2048;
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
            int index = (int) (((bytes[offset] & 0xFF) << 24) | ((bytes[offset + 1] & 0xFF) << 16)
                    | ((bytes[offset + 2] & 0xFF) << 8) | (bytes[offset + 3] & 0xFF));
            int length = (int) (((bytes[offset + 4] & 0xFF) << 24) | ((bytes[offset + 5] & 0xFF) << 16)
                    | ((bytes[offset + 6] & 0xFF) << 8) | (bytes[offset + 7] & 0xFF));
            if (index == 0) {
                break;
            }
            CEMassage massage = new CEMassage(datagramPacket.getAddress());
            byte[] args = Arrays.copyOfRange(bytes, offset + 8, offset + 8 + length);
            for (int i = 0; i < args.length; i++) {
                massage.bytes.add(args[i]);
            }
            command.Execute(index, massage);
            offset += length + 8;
            if (bytes.length - offset < 8) {
                break;
            }
        }
    }

    public void RegisterInstruction(int index, CEInstruction instruction) {
        command.RegisterInstruction(index, instruction);
    }

    public void SendMessage(CEMassage message, int port) {
        byte[] bytes = message.GetAllBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, message.inetAddress, port);
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