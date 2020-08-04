package pers.crystal.engine.components;

import java.net.InetAddress;
import java.net.UnknownHostException;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.net.CEClientSync;
import pers.crystal.engine.utility.net.CEInstruction;
import pers.crystal.engine.utility.net.CEMessage;
import pers.crystal.engine.utility.net.CESocket;
import pers.crystal.engine.utility.net.CESyncValue;

public class CEClient extends CEComponent implements CEInstruction {
    public static final byte SIGNAL_CONNECT_RESULT = 1;

    private InetAddress inetAddress;
    public int port = 4231;
    CESocket socket = new CESocket(port);
    
    private CEClientSync clientSync;
    public CEClient() {
        clientSync = new CEClientSync();
        socket.RegisterInstruction("CEClient",this);
        socket.RegisterInstruction("CEClientSync",clientSync);
    }

    @Override
    public void Start() {
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update() {

    }

    @Override
    public void Destroy() {

    }

    public void Connect(InetAddress inetAddress, int port) {
        socket.SendMessage(new CEMessage().AddInstruction("CEServer",CEServer.SIGNAL_CONNECT,this.port), inetAddress, port);
    }

    public void DisConnect(InetAddress inetAddress, int port) {
        socket.SendMessage(new CEMessage().AddInstruction("CEServer",CEServer.SIGNAL_DISCONNECT, this.port), inetAddress, port);
    }

    public void SendMessage(CEMessage message, int port) {
        socket.SendMessage(message, inetAddress, port);
    }

    public CESyncValue CreateSyncValue(String key) {
        return clientSync.Create(key);
    }

    @Override
    public synchronized void Do(InetAddress inetAddress, CEMessage massage) {
        switch (massage.GetByte()){
            case SIGNAL_CONNECT_RESULT:
                    CONNECT_RESULT(inetAddress, massage);
                break;
        
            default:
                break;
        }
    }

    private void CONNECT_RESULT(InetAddress inetAddress, CEMessage massage) {
        boolean bool = massage.GetBoolean();
        if (bool) {
            this.inetAddress = inetAddress;
            System.out.println("Connection succeeded");
        } else {
            System.out.println("Connection failed");
        }
    }
}