package pers.crystal.engine.utility.net;

import pers.crystal.engine.components.CEServer;

public class CESyncValue {
    public static final byte TYPE_INTEGER = 1;
    public static final byte TYPE_STRING = 2;
    public static final byte TYPE_FLOAT = 3;
    public static final byte TYPE_DOUBLE = 4;
    public static final byte TYPE_CHARACTER = 5;
    public static final byte TYPE_BYTE = 6;
    public static final byte TYPE_BOOLEAN = 7;
    public static final byte TYPE_SHORT = 8;
    public static final byte TYPE_LONG = 9;

    private CEServer server = null;
    private String key;
    private byte type;
    private Object value = null;

    CESyncValue(String key) {
        this.key = key;
    }

    CESyncValue(CEServer server, String key, byte type, Object value) {
        this.server = server;
        this.key = key;
        this.type = type;
        this.SetValue(value);
    }

    public static byte Type(Object value){
        if (value instanceof Integer) {
            return CESyncValue.TYPE_INTEGER;
        } else if (value instanceof String) {
            return CESyncValue.TYPE_STRING;
        } else if (value instanceof Float) {
            return CESyncValue.TYPE_FLOAT;
        } else if (value instanceof Double) {
            return CESyncValue.TYPE_DOUBLE;
        } else if (value instanceof Character) {
            return CESyncValue.TYPE_CHARACTER;
        } else if (value instanceof Byte) {
            return CESyncValue.TYPE_BYTE;
        }else if (value instanceof Boolean) {
            return CESyncValue.TYPE_BOOLEAN;
        }else if (value instanceof Short) {
            return CESyncValue.TYPE_SHORT;
        }else if (value instanceof Long) {
            return CESyncValue.TYPE_LONG;
        }else {
            throw new RuntimeException();
        }
    } 

    public void SetValue(Object value) {
        this.value = value;
        if (server != null) {
            type = Type(value);
            CEMessage message = new CEMessage();
            message.AddInstruction("CEClientSync", CEClientSync.SIGNAL_ONSYNC, key, type, value);
            server.SendMessage(message);
        }
    }

    public String GetKey() {
        return key;
    }

    public byte GetType() {
        return type;
    }

    public Object GetValue() {
        return value;
    }
}