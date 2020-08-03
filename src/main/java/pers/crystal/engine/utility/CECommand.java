package pers.crystal.engine.utility;

import java.util.*;

import pers.crystal.engine.utility.net.CEMassage;

public class CECommand
{
	private HashMap<Integer,CEInstruction> instructionSet = new HashMap<Integer,CEInstruction>();
	
	public void RegisterInstruction(int index,CEInstruction instruction){
		if(instructionSet.containsKey(index)){
			throw new RuntimeException();
		}
		instructionSet.put(index,instruction);
	}
	
	public void RemoveInstruction(Integer index){
		if(!instructionSet.containsKey(index)){
			throw new RuntimeException();
		}
		instructionSet.remove(index);
	}
	
	public void Execute(Integer index,CEMassage massage){
		instructionSet.get(index).Do(massage);	
	}
}
