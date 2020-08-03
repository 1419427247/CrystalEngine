package pers.crystal.engine.components;

import java.net.InetAddress;
import java.net.SocketAddress;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.CEInstruction;
import pers.crystal.engine.utility.net.CEMassage;
import pers.crystal.engine.utility.net.CESocket;
import pers.crystal.engine.utility.net.CESyncValue;

public class CEClient extends CEComponent {
    public static final int SYNCVALUE = 1;

    CESocket socket = new CESocket(4231);

    @Override
    public void Start() {
        socket.RegisterInstruction(SYNCVALUE, new CEInstruction() {
            @Override
            public void Do(CEMassage massage) {
                int type = massage.GetByte();
                switch (type) {
                    case CESyncValue.TYPE_INT:
                    
                        break;
                    case CESyncValue.TYPE_CAHR:

                        break;
                    case CESyncValue.TYPE_STRING:

                        break;
                    case CESyncValue.TYPE_BOOLEAN:

                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void Update() {

    }

    @Override
    public void Destroy() {
        // TODO Auto-generated method stub

    }
}