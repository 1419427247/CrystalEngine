package pers.crystal.engine.utility.net;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * CEMassage
 */
public class CEMessage {
    public int offset = 0;

    public ArrayList<Byte> bytes = new ArrayList<Byte>();

    public CEMessage() {

    }

    public CEMessage AddInstruction(String key, byte signal, Object... args) {
        int length = 0;
        AddInt(length);
        length += AddString(key);
        length += AddByte(signal);
        for (int i = 0; i < args.length; i++) {
            length += Add(args[i]);
        }
        SetInt(bytes.size() - length - 4, length);
        return this;
    }

    public int Add(Object value){
        if (value instanceof Integer) {
            return AddInt((int) value);
        } else if (value instanceof String) {
            return AddString((String) value);
        } else if (value instanceof Float) {
            return AddFloat((Float) value);
        } else if (value instanceof Double) {
            return AddDouble((Double) value);
        } else if (value instanceof Character) {
            return AddChar((char) value);
        } else if (value instanceof Byte) {
            return AddByte((byte) value);
        } else if (value instanceof Boolean) {
            return AddBoolean((boolean) value);
        } else if (value instanceof Short) {
            return AddShort((Short) value);
        } else if (value instanceof Long) {
            return AddLong((Long) value);
        } else {
            throw new RuntimeException();
        }
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

    public int AddShort(short value) {
        this.bytes.add((byte) (value & 0xff));
        this.bytes.add((byte) ((value & 0xff00) >> 8));
        return 2;
    }

    public short getShort() {
        short value = (short) ((0xff & this.bytes.get(offset)) | (0xff00 & (this.bytes.get(offset + 1) << 8)));
        offset += 2;
        return value;
    }

    public int AddLong(long value) {
        this.bytes.add((byte) (value & 0xff));
        this.bytes.add((byte) ((value >> 8) & 0xff));
        this.bytes.add((byte) ((value >> 16) & 0xff));
        this.bytes.add((byte) ((value >> 24) & 0xff));
        this.bytes.add((byte) ((value >> 32) & 0xff));
        this.bytes.add((byte) ((value >> 40) & 0xff));
        this.bytes.add((byte) ((value >> 48) & 0xff));
        this.bytes.add((byte) ((value >> 56) & 0xff));
        return 8;
    }

    public long getLong() {
        long value = (0xffL & (long) this.bytes.get(offset) 
                | (0xff00L & ((long) this.bytes.get(offset + 1) << 8))
                | (0xff0000L & ((long) this.bytes.get(offset + 2) << 16))
                | (0xff000000L & ((long) this.bytes.get(offset + 3) << 24))
                | (0xff00000000L & ((long) this.bytes.get(offset + 4) << 32))
                | (0xff0000000000L & ((long) this.bytes.get(offset + 5) << 40))
                | (0xff000000000000L & ((long) this.bytes.get(offset + 6) << 48))
                | (0xff00000000000000L & ((long) this.bytes.get(offset + 7) << 56)));
        offset += 8;
        return value;
    }

    public int AddFloat(float value) {
        return AddInt(Float.floatToIntBits(value));
    }

    public float GetFloat() {
        return Float.intBitsToFloat(GetInt());
    }

    public int AddDouble(double value) {
        return AddLong(Double.doubleToLongBits(value));
    }

    public double GetDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public byte[] GetAllBytes() {
        byte[] bytes = new byte[this.bytes.size()];
        for (int i = 0; i < this.bytes.size(); i++) {
            bytes[i] = this.bytes.get(i);
        }
        return bytes;
    }

}