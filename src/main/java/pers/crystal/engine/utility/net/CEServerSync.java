package pers.crystal.engine.utility.net;

import java.util.ArrayList;

import pers.crystal.engine.components.CEServer;

public class CEServerSync {
	public ArrayList<CESyncValue> syncValues = new ArrayList<CESyncValue>();
	private CEServer server = null;

	public CEServerSync(CEServer server) {
		this.server = server;
	}

	public CESyncValue Create(String key, Object value) {
		CESyncValue syncValue = new CESyncValue(server,key, value);
		syncValues.add(syncValue);
		return syncValue;
	}
}
