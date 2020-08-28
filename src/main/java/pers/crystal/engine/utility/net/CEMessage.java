package pers.crystal.engine.utility.net;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * CEMassage
 */
public class CEMessage {
    public static final byte TYPE_INTEGER = 1;
    public static final byte TYPE_STRING = 2;
    public static final byte TYPE_FLOAT = 3;
    public static final byte TYPE_DOUBLE = 4;
    public static final byte TYPE_CHARACTER = 5;
    public static final byte TYPE_BYTE = 6;
    public static final byte TYPE_BYTES = 7;
    public static final byte TYPE_BOOLEAN = 8;
    public static final byte TYPE_SHORT = 9;
    public static final byte TYPE_LONG = 10;

    public int offset = 0;

    public ArrayList<Byte> bytes = new ArrayList<Byte>();

    public CEMessage() {

    }

    public CEMessage AddInstruction(String key, byte signal, Object... args) {
        int length = 0;
        Add(length);
        length += Add(key);
        length += Add(signal);
        length += Add(args);
        SetInt(bytes.size() - length - 4, length);
        return this;
    }

    public int Add(Object... values) {
        int length = 0;
        for (Object value : values) {
            if (value instanceof Integer) {
                AddByte(TYPE_INTEGER);
                length += AddInt((int) value) + 1;
            } else if (value instanceof String) {
                AddByte(TYPE_STRING);
                length += AddString((String) value) + 1;
            } else if (value instanceof Float) {
                AddByte(TYPE_FLOAT);
                length += AddFloat((Float) value) + 1;
            } else if (value instanceof Double) {
                AddByte(TYPE_DOUBLE);
                length += AddDouble((Double) value) + 1;
            } else if (value instanceof Character) {
                AddByte(TYPE_CHARACTER);
                length += AddChar((char) value) + 1;
            } else if (value instanceof Byte) {
                AddByte(TYPE_BYTE);
                length += AddByte((byte) value) + 1;
            } else if (value instanceof byte[]) {
                AddByte(TYPE_BYTES);
                length += AddBytes((byte[]) value) + 1;
            } else if (value instanceof Boolean) {
                AddByte(TYPE_BOOLEAN);
                length += AddBoolean((boolean) value) + 1;
            } else if (value instanceof Short) {
                AddByte(TYPE_SHORT);
                length += AddShort((Short) value) + 1;
            } else if (value instanceof Long) {
                AddByte(TYPE_LONG);
                length += AddLong((Long) value) + 1;
            } else {
                throw new RuntimeException();
            }
        }
        return length;
    }

    public Object[] GetAll() {
        ArrayList<Object> objects = new ArrayList<Object>();
        while (offset < bytes.size()) {
            objects.add(Get());
        }
        return objects.toArray();
    }

    public Object Get() {
        byte type = GetByte();
        if (type == TYPE_INTEGER) {
            return GetInt();
        } else if (type == TYPE_STRING) {
            return GetString();
        } else if (type == TYPE_FLOAT) {
            return GetFloat();
        } else if (type == TYPE_DOUBLE) {
            return GetDouble();
        } else if (type == TYPE_CHARACTER) {
            return GetChar();
        } else if (type == TYPE_BYTE) {
            return GetByte();
        } else if (type == TYPE_BYTES) {
            return GetBytes();
        } else if (type == TYPE_BOOLEAN) {
            return GetBoolean();
        } else if (type == TYPE_SHORT) {
            return getShort();
        } else if (type == TYPE_LONG) {
            return getLong();
        } else {
            throw new RuntimeException();
        }
    }

    private int AddInt(int value) {
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

    private int GetInt() {
        int value = (int) (((bytes.get(offset) & 0xFF) << 24) | ((bytes.get(offset + 1) & 0xFF) << 16)
                | ((bytes.get(offset + 2) & 0xFF) << 8) | (bytes.get(offset + 3) & 0xFF));
        offset += 4;
        return value;
    }

    private int AddChar(char value) {
        bytes.add((byte) ((value >> 8) & 0xFF));
        bytes.add((byte) (value & 0xFF));
        return 2;
    }

    private char GetChar() {
        char value = (char) (((bytes.get(offset) & 0xFF) << 8) | (bytes.get(offset + 1) & 0xFF));
        offset += 2;
        return value;
    }

    private int AddBoolean(boolean value) {
        bytes.add((byte) (value ? 1 : 0));
        return 1;
    }

    private boolean GetBoolean() {
        boolean value = bytes.get(offset) == 0 ? false : true;
        offset += 1;
        return value;
    }

    private int AddByte(byte value) {
        this.bytes.add(value);
        return 1;
    }

    private byte GetByte() {
        byte value = this.bytes.get(offset);
        offset += 1;
        return value;
    }

    private int AddString(String value) {
        try {
            byte[] bytes = value.getBytes("UTF8");
            return AddBytes(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private String GetString() {
        String value = null;
        try {
            value = new String(GetBytes(), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    private int AddBytes(byte[] values) {
        int length = AddInt(values.length);
        for (int i = 0; i < values.length; i++) {
            this.bytes.add(values[i]);
        }
        return length + values.length;
    }

    private byte[] GetBytes() {
        int length = GetInt();
        byte[] bytes = new byte[length];
        for (int i = offset; i < offset + length; i++) {
            bytes[i - offset] = this.bytes.get(i);
        }
        offset += bytes.length;
        return bytes;
    }

    private int AddShort(short value) {
        this.bytes.add((byte) (value & 0xff));
        this.bytes.add((byte) ((value & 0xff00) >> 8));
        return 2;
    }

    private short getShort() {
        short value = (short) ((0xff & this.bytes.get(offset)) | (0xff00 & (this.bytes.get(offset + 1) << 8)));
        offset += 2;
        return value;
    }

    private int AddLong(long value) {
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

    private long getLong() {
        long value = (0xffL & (long) this.bytes.get(offset) | (0xff00L & ((long) this.bytes.get(offset + 1) << 8))
                | (0xff0000L & ((long) this.bytes.get(offset + 2) << 16))
                | (0xff000000L & ((long) this.bytes.get(offset + 3) << 24))
                | (0xff00000000L & ((long) this.bytes.get(offset + 4) << 32))
                | (0xff0000000000L & ((long) this.bytes.get(offset + 5) << 40))
                | (0xff000000000000L & ((long) this.bytes.get(offset + 6) << 48))
                | (0xff00000000000000L & ((long) this.bytes.get(offset + 7) << 56)));
        offset += 8;
        return value;
    }

    private int AddFloat(float value) {
        return AddInt(Float.floatToIntBits(value));
    }

    private float GetFloat() {
        return Float.intBitsToFloat(GetInt());
    }

    private int AddDouble(double value) {
        return AddLong(Double.doubleToLongBits(value));
    }

    private double GetDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public byte[] GetAllBytes() {
        byte[] bytes = new byte[this.bytes.size()];
        for (int i = 0; i < this.bytes.size(); i++) {
            bytes[i] = this.bytes.get(i);
        }
        return bytes;
    }

    public int size() {
        return bytes.size();
    }
}