package pers.crystal.engine.components;

import java.net.*;
import java.util.*;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.CEInstruction;
import pers.crystal.engine.utility.net.*;

public class CEServer extends CEComponent {
    public static int port = 4232;
    private CESocket socket = new CESocket(port);

    LinkedList<InetAddress> clients = new LinkedList<InetAddress>();
    HashSet<String> set = new HashSet<String>();

    CESync sync = null;

    public CEServer() {
        sync = new CESync(this);
        socket.RegisterInstruction("CONNECT", new CEInstruction() {
            @Override
            public void Do(InetAddress inetAddress, CEMessage massage) {
                if (set.contains(inetAddress.getHostAddress())) {
                    socket.SendMessage(new CEMessage().AddInstruction("CONNECTION", false), inetAddress, 4231);
                } else {
                    socket.SendMessage(new CEMessage().AddInstruction("CONNECTION", true), inetAddress, 4231);
                    clients.add(inetAddress);
                    set.add(inetAddress.getHostAddress());
                }
            }
        });
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

    public void SendMessage() {

    }

    public void SendMessage(CEMessage message) {
        for (InetAddress inetAddress : clients) {
            socket.SendMessage(message, inetAddress, CEClient.port);
        }
    }

    public void SendMessage(CEMessage message, int port) {
        for (InetAddress inetAddress : clients) {
            socket.SendMessage(message, inetAddress, port);
        }
    }

    public void SendMessage(CEMessage message, InetAddress inetAddress, int port) {
        socket.SendMessage(message, inetAddress, port);
    }

    public <T> CESyncValue<T> CreateSyncValue(String key, T value) {
        return sync.Create(key, value);
    }
}