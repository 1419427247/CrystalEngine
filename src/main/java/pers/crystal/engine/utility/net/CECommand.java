package pers.crystal.engine.utility.net;

import java.net.InetAddress;
import java.util.*;

import pers.crystal.engine.components.CEServer;
import pers.crystal.engine.utility.net.CEMessage;

public class CECommand
{
	private HashMap<String,CEInstruction> instructionSet = new HashMap<String,CEInstruction>();
	
	public void RegisterInstruction(String key,CEInstruction instruction){
		if(instructionSet.containsKey(key)){
			throw new RuntimeException();
		}
		instructionSet.put(key,instruction);
	}
	
	public void RemoveInstruction(String key){
		if(!instructionSet.containsKey(key)){
			throw new RuntimeException();
		}
		instructionSet.remove(key);
	}
	
	public void Execute(String key,InetAddress inetAddress,CEMessage massage){
		instructionSet.get(key).Do(inetAddress,massage);	
	}
}
