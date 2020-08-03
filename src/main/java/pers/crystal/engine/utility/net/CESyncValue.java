package pers.crystal.engine.utility.net;

import java.util.*;

import pers.crystal.engine.utility.CEInstruction;

public class CESyncValue {
	public static final byte TYPE_INT = 1;
	public static final byte TYPE_CAHR = 2;
	public static final byte TYPE_STRING = 3;
	public static final byte TYPE_BOOLEAN = 4;

	public static HashMap<String, CESyncValue> values = new HashMap<String, CESyncValue>();

	private byte type;
	private Object value;

	private CESyncValue(byte type, Object value) {
		this.value = value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public static CESyncValue Create(String key, byte type, Object value) {
		if (values.containsKey(key)) {
			return values.get(key);
		}
		CESyncValue v = new CESyncValue(type, value);
		values.put(key, v);
		return v;
	}
}
