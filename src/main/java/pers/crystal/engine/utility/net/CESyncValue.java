package pers.crystal.engine.utility.net;

import pers.crystal.engine.components.CEServer;

public class CESyncValue {

    private CEServer server = null;
    private String key;
    private Object value = null;

    CESyncValue(String key) {
        this.key = key;
    }

    CESyncValue(CEServer server, String key, Object value) {
        this.server = server;
        this.key = key;
        this.SetValue(value);
    }

    public void SetValue(Object value) {
        this.value = value;
        if (server != null) {
            server.SendMessage(new CEMessage().AddInstruction("CEClientSync", CEClientSync.SIGNAL_ONSYNC, key, value));
        }
    }

    public String GetKey() {
        return key;
    }

    public Object GetValue() {
        return value;
    }
}