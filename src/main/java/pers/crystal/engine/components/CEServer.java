package pers.crystal.engine.components;

import java.net.*;
import java.security.MessageDigestSpi;
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

    public static int port = 4232;
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

    @Override
    public void Update() {

    }

    @Override
    public void Destroy() {

    }

    public void RegisterInstruction(String key, CEInstruction instruction) {
        socket.RegisterInstruction(key, instruction);
    }

    public void SendMessage(CEMessage message) {
        synchronized (this) {
            for (Client client : clients) {
                socket.SendMessage(message, client.inetAddress, client.port);
            }
        }
    }

    public void SendMessage(CEMessage message, InetAddress inetAddress, int port) {
        socket.SendMessage(message, inetAddress, port);
    }

    public CESyncValue CreateSyncValue(String key, Object value) {
        return serverSync.Create(key, value);
    }

    @Override
    public synchronized void Do(InetAddress inetAddress, CEMessage massage) {
        switch (massage.GetByte()) {
            case SIGNAL_CONNECT:
                CONNECT(inetAddress, massage);
                break;
            case SIGNAL_DISCONNECT:
                DISCONNECT(inetAddress, massage);
                break;

            default:
                throw new RuntimeException();
        }
    }

    private void CONNECT(InetAddress inetAddress, CEMessage massage) {
        int port = massage.GetInt();
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
                        syncValues.GetType(), syncValues.GetValue());
            }
            this.SendMessage(message, inetAddress, port);
        }
    }

    private void DISCONNECT(InetAddress inetAddress, CEMessage massage) {
        clients.remove(clientMap.get(inetAddress.getHostAddress()));
        clientMap.remove(inetAddress.getHostAddress());
    }
}