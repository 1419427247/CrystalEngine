package pers.crystal.engine.utility.net;

import java.util.*;

import javax.print.DocFlavor.STRING;

import pers.crystal.engine.components.CEServer;
import pers.crystal.engine.utility.CEInstruction;

public class CESync {
	private CEServer server = null;
	public CESync(CEServer server) {
		this.server = server;
	}

	public <T> CESyncValue<T> Create(String key, T value) {
		byte type;
		if (value instanceof Integer) {
			type = CESyncValue.TYPE_INT;
		} else if (value instanceof Character) {
			type = CESyncValue.TYPE_CAHR;
		} else if (value instanceof Byte) {
			type = CESyncValue.TYPE_BYTE;
		} else if (value instanceof String) {
			type = CESyncValue.TYPE_STRING;
		} else if (value instanceof Boolean) {
			type = CESyncValue.TYPE_BOOLEAN;
		} else {
			throw new RuntimeException();
		}
		return new CESyncValue<T>(server, type, value);
	}
}
