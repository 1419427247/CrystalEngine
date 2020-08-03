package pers.crystal.engine.utility.net;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.ArrayList;

/**
 * CEMassage
 */
public class CEMessage {
    public int offset = 0;

    public ArrayList<Byte> bytes = new ArrayList<Byte>();

    public CEMessage() {

    }

    public CEMessage AddInstruction(String key, Object... args) {
        int length = 0;
        AddInt(length);
        length += AddString(key);
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                length += AddInt((int) args[i]);
            } else if (args[i] instanceof Character) {
                length += AddChar((char) args[i]);
            } else if (args[i] instanceof Byte) {
                length += AddByte((byte) args[i]);
            } else if (args[i] instanceof String) {
                length += AddString((String) args[i]);
            } else if (args[i] instanceof Boolean) {
                length += AddBoolean((boolean) args[i]);
            } else {
                throw new RuntimeException();
            }
        }
        SetInt(bytes.size() - length - 4, length);
        return this;
    }

    public int AddInt(int value) {
        bytes.add((byte) ((value >> 24) & 0xFF));
        bytes.add((byte) ((value >> 16) & 0xFF));
        bytes.add((byte) ((value >> 8) & 0xFF));
        bytes.add((byte) (value & 0xFF));
        return 4;
    }

    public void SetInt(int offset, int value) {
        bytes.set(offset, (byte) ((value >> 24) & 0xFF));
        bytes.set(offset + 1, (byte) ((value >> 16) & 0xFF));
        bytes.set(offset + 2, (byte) ((value >> 8) & 0xFF));
        bytes.set(offset + 3, (byte) (value & 0xFF));
    }

    public int GetInt() {
        int value = (int) (((bytes.get(offset) & 0xFF) << 24) | ((bytes.get(offset + 1) & 0xFF) << 16)
                | ((bytes.get(offset + 2) & 0xFF) << 8) | (bytes.get(offset + 3) & 0xFF));
        offset += 4;
        return value;
    }

    public int AddChar(char value) {
        bytes.add((byte) ((value >> 8) & 0xFF));
        bytes.add((byte) (value & 0xFF));
        return 2;
    }

    public void SetChar(int offset, int value) {
        bytes.set(offset, (byte) ((value >> 8) & 0xFF));
        bytes.set(offset + 1, (byte) (value & 0xFF));
    }

    public char GetChar() {
        char value = (char) (((bytes.get(offset) & 0xFF) << 8) | (bytes.get(offset + 1) & 0xFF));
        offset += 2;
        return value;
    }

    public int AddBoolean(boolean value) {
        bytes.add((byte) (value ? 1 : 0));
        return 1;
    }

    public void SetBoolean(int offset, boolean value) {
        bytes.set(offset, (byte) (value ? 1 : 0));
    }

    public boolean GetBoolean() {
        boolean value = bytes.get(offset) == 0 ? false : true;
        offset += 1;
        return value;
    }

    public int AddByte(byte value) {
        this.bytes.add(value);
        return 1;
    }

    public byte GetByte() {
        byte value = this.bytes.get(offset);
        offset += 1;
        return value;
    }

    public int AddString(String value) {
        try {
            byte[] bytes = value.getBytes("UTF8");
            return AddBytes(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // public void SetString(int offset, String value) {
    // bytes.set(offset, (byte) (value ? 1 : 0));
    // }

    public String GetString() {
        String value = null;
        try {
            value = new String(GetBytes(), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public int AddBytes(byte[] values) {
        int length = AddInt(values.length);
        for (int i = 0; i < values.length; i++) {
            this.bytes.add(values[i]);
        }
        return length + values.length;
    }

    public byte[] GetBytes() {
        int length = GetInt();
        byte[] bytes = new byte[length];
        for (int i = offset; i < offset + length; i++) {
            bytes[i - offset] = this.bytes.get(i);
        }
        offset += bytes.length;
        return bytes;
    }

    public byte[] GetAllBytes() {
        byte[] bytes = new byte[this.bytes.size()];
        for (int i = 0; i < this.bytes.size(); i++) {
            bytes[i] = this.bytes.get(i);
        }
        return bytes;
    }

}