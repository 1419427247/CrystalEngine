package pers.crystal.engine.components;

import java.net.*;
import java.util.*;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.net.*;

public class CEServer extends CEComponent implements CEInstruction {
    public static final byte SIGNAL_CONNECT = 1;
    public static final byte SIGNAL_DISCONNECT = 2;

    class Client {
        public InetAddress inetAddress;
        public int port;

        public Client(InetAddress inetAddress, int port) {
            this.inetAddress = inetAddress;
            this.port = port;
        }
    }

    public static int port = 13501;
    private CESocket socket = new CESocket(port);

    private LinkedList<Client> clients = new LinkedList<Client>();
    private HashMap<String, Client> clientMap = new HashMap<String, Client>();

    CEServerSync serverSync = null;

    public CEServer() {
        serverSync = new CEServerSync(this);
        socket.RegisterInstruction("CEServer", this);
    }

    @Override
    public void Start() {

    }

    private LinkedList<CEMessage> messages = new LinkedList<CEMessage>();

    @Override
    public void Update() {
        while (!messages.isEmpty()) {
            for (Client client : clients) {
                socket.SendMessage(messages.poll(), client.inetAddress, client.port);
            }
        }
    }

    @Override
    public void Destroy() {
        socket.Close();
    }

    public void RegisterInstruction(String key, CEInstruction instruction) {
        socket.RegisterInstruction(key, instruction);
    }

    public void SendMessage(CEMessage message) {
        if (messages.isEmpty()) {
            messages.add(message);
        }else if (messages.getLast().size() + message.size() <= CESocket.DATA_MAX_LENGTH){
                messages.getLast().bytes.addAll(message.bytes);
        }else{
            messages.add(message);
        }
    }

    public void SendMessage(CEMessage message, InetAddress inetAddress, int port) {
        socket.SendMessage(message, inetAddress, port);
    }

    public CESyncValue CreateSyncValue(String key, Object value) {
        return serverSync.Create(key, value);
    }

    @Override
    public void Do(InetAddress inetAddress, byte signal, Object... args) {
        switch (signal) {
            case SIGNAL_CONNECT:
                CONNECT(inetAddress, args);
                break;
            case SIGNAL_DISCONNECT:
                DISCONNECT(inetAddress, args);
                break;

            default:
                throw new RuntimeException();
        }
    }

    private void CONNECT(InetAddress inetAddress, Object... args) {
        int port = (int) args[0];
        if (clientMap.containsKey(inetAddress.getHostAddress())) {
            socket.SendMessage(new CEMessage().AddInstruction("CEClient", CEClient.SIGNAL_CONNECT_RESULT, false),
                    inetAddress, port);
        } else {
            socket.SendMessage(new CEMessage().AddInstruction("CEClient", CEClient.SIGNAL_CONNECT_RESULT, true),
                    inetAddress, port);
            Client client = new Client(inetAddress, port);
            clients.add(client);
            clientMap.put(inetAddress.getHostAddress(), client);

            CEMessage message = new CEMessage();
            for (CESyncValue syncValues : serverSync.syncValues) {
                message.AddInstruction("CEClientSync", CEClientSync.SIGNAL_ONSYNC, syncValues.GetKey(),
                        syncValues.GetValue());
            }
            this.SendMessage(message, inetAddress, port);
        }
    }

    private void DISCONNECT(InetAddress inetAddress, Object... args) {
        clients.remove(clientMap.get(inetAddress.getHostAddress()));
        clientMap.remove(inetAddress.getHostAddress());
    }
}