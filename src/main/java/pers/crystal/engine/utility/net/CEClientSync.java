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
    public void Do(InetAddress inetAddress, byte signal, Object... args) {
        switch (signal) {
            case SIGNAL_ONSYNC:
                ONSYNC(inetAddress, args);
                break;
            default:
                throw new RuntimeException();
        }
    }

    private void ONSYNC(InetAddress inetAddress, Object... args) {
        String key = (String) args[0];
        syncValues.get(key).SetValue(args[1]);
    }
}
