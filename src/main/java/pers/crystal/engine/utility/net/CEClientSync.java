package pers.crystal.engine.utility.net;

import java.net.InetAddress;
import java.util.HashMap;

public class CEClientSync implements CEInstruction {
    public static final byte SIGNAL_ONSYNC = 1;

    private HashMap<String, CESyncValue> syncValues = new HashMap<String, CESyncValue>();

    public CEClientSync() {
    }

    public CESyncValue Create(String key) {
        CESyncValue syncValue = new CESyncValue(key);
        syncValues.put(key, syncValue);
        return syncValue;
    }

    @Override
    public void Do(InetAddress inetAddress, CEMessage massage) {
        switch (massage.GetByte()) {
            case SIGNAL_ONSYNC:
                ONSYNC(inetAddress, massage);
                break;
            default:
                throw new RuntimeException();
        }
    }

    private void ONSYNC(InetAddress inetAddress, CEMessage massage) {
        String key = massage.GetString();
        byte type = massage.GetByte();
        if (type == CESyncValue.TYPE_INTEGER) {
            syncValues.get(key).SetValue(massage.GetInt());
        } else if (type == CESyncValue.TYPE_STRING) {
            syncValues.get(key).SetValue(massage.GetString());
        } else if (type == CESyncValue.TYPE_FLOAT) {
            syncValues.get(key).SetValue(massage.GetFloat());
        } else if (type == CESyncValue.TYPE_DOUBLE) {
            syncValues.get(key).SetValue(massage.GetDouble());
        } else if (type == CESyncValue.TYPE_CHARACTER) {
            syncValues.get(key).SetValue(massage.GetChar());
        }else if (type == CESyncValue.TYPE_BYTE) {
            syncValues.get(key).SetValue(massage.GetByte());
        }else if (type == CESyncValue.TYPE_BOOLEAN) {
            syncValues.get(key).SetValue(massage.GetBoolean());
        }else if (type == CESyncValue.TYPE_SHORT) {
            syncValues.get(key).SetValue(massage.getShort());
        }else if (type == CESyncValue.TYPE_LONG) {
            syncValues.get(key).SetValue(massage.getLong());
        } else {
            throw new RuntimeException();
        }
    }
}
