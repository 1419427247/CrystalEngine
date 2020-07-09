package CEUtility;
import java.util.*;

public class CECommand
{
	private HashMap<String,CEInstruction> instructionSet = new HashMap<String,CEInstruction>();
	
	public void AddInstruction(String name,CEInstruction instruction){
		if(instructionSet.containsKey(name)){
			throw new RuntimeException();
		}
		instructionSet.put(name,instruction);
	}
	
	public void RemoveInstruction(String name){
		if(!instructionSet.containsKey(name)){
			throw new RuntimeException();
		}
		instructionSet.remove(name);
	}
	
	public Object Execute(String name,String ...param){
		return instructionSet.get(name).Do(param);	
	}
}
