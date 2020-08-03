package pers.crystal.engine.components;

import java.net.InetAddress;
import java.net.UnknownHostException;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.CEInstruction;
import pers.crystal.engine.utility.net.CEMessage;
import pers.crystal.engine.utility.net.CESocket;

public class CEClient extends CEComponent {
    public static int port = 4231;
    CESocket socket = new CESocket(port);
    private InetAddress inetAddress;

    public CEClient() {
        socket.RegisterInstruction("CONNECTION", new CEInstruction() {
            @Override
            public void Do(InetAddress iAddress, CEMessage massage) {
                boolean bool = massage.GetBoolean();
                if (bool) {
                    inetAddress = iAddress;
                    System.out.println("Connection succeeded");
                } else {
                    System.out.println("Connection failed");
                }
            }
        });

        socket.RegisterInstruction("SYNCVALUE", new CEInstruction() {
            @Override
            public void Do(InetAddress iAddress, CEMessage massage) {
                System.out.println(massage.GetByte());
            }
        });
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
        socket.SendMessage(new CEMessage().AddInstruction("CONNECT"), inetAddress, port);
    }

    public void SendMessage(CEMessage message, int port) {
        socket.SendMessage(message, inetAddress, port);
    }
}