package pers.crystal.engine.utility.net;

import pers.crystal.engine.components.CEServer;

public class CESyncValue<T> {
    public static final byte TYPE_INT = 1;
    public static final byte TYPE_CAHR = 2;
    public static final byte TYPE_STRING = 3;
    public static final byte TYPE_BYTE = 5;
    public static final byte TYPE_BOOLEAN = 5;

    private CEServer server = null;
    private byte type;
    private T value = null;

    CESyncValue(CEServer server, byte type, T value) {
        this.server = server;
        this.type = type;
        this.value = value;
    }

    public void SetValue(T value) {
        this.value = value;
        CEMessage message = new CEMessage();
        message.AddInstruction("SYNCVALUE", type, value);
        server.SendMessage(message);
    }
}