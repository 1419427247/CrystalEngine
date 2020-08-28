package pers.crystal.engine.components;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.net.CEClientSync;
import pers.crystal.engine.utility.net.CEInstruction;
import pers.crystal.engine.utility.net.CEMessage;
import pers.crystal.engine.utility.net.CESocket;
import pers.crystal.engine.utility.net.CESyncValue;

public class CEClient extends CEComponent implements CEInstruction {
    public static final byte SIGNAL_CONNECT_RESULT = 1;

    private InetAddress inetAddress;
    public int port = 8;
    CESocket socket = new CESocket(port);

    private CEClientSync clientSync;

    public CEClient() {
        clientSync = new CEClientSync();
        socket.RegisterInstruction("CEClient", this);
        socket.RegisterInstruction("CEClientSync", clientSync);
    }

    public void RegisterInstruction(String key, CEInstruction instruction) {
        socket.RegisterInstruction(key, instruction);
    }

    @Override
    public void Start() {
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private LinkedList<CEMessage> messages = new LinkedList<CEMessage>();

    @Override
    public void Update() {
        while (!messages.isEmpty()) {
            socket.SendMessage(messages.poll(), inetAddress, port);
        }
    }

    @Override
    public void Destroy() {
        socket.Close();
    }

    public void Connect(InetAddress inetAddress, int port) {
        socket.SendMessage(new CEMessage().AddInstruction("CEServer", CEServer.SIGNAL_CONNECT, this.port), inetAddress,
                port);
    }

    public void DisConnect(InetAddress inetAddress, int port) {
        socket.SendMessage(new CEMessage().AddInstruction("CEServer", CEServer.SIGNAL_DISCONNECT,this.port),
                inetAddress, port);
    }

    public void SendMessage(CEMessage message) {
        if (messages.isEmpty()) {
            messages.add(message);
        } else if (messages.getLast().size() + message.size() <= CESocket.DATA_MAX_LENGTH) {
            messages.getLast().bytes.addAll(message.bytes);
        } else {
            messages.add(message);
        }
    }

    public CESyncValue CreateSyncValue(String key) {
        return clientSync.Create(key);
    }

    @Override
    public void Do(InetAddress inetAddress, byte signal, Object... args) {
        switch (signal) {
            case SIGNAL_CONNECT_RESULT:
                CONNECT_RESULT(inetAddress, args);
                break;

            default:
                break;
        }
    }

    private void CONNECT_RESULT(InetAddress inetAddress, Object... args) {
        boolean bool = (boolean) args[0];
        if (bool) {
            this.inetAddress = inetAddress;
            System.out.println("Connection succeeded");
        } else {
            System.out.println("Connection failed");
        }
    }
}