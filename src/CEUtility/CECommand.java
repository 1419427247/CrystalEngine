package CEUtility;
import java.util.*;

public class CECommand
{
	private static HashMap<String,CEInstruction> instructionSet = new HashMap<String,CEInstruction>();
	
	public static void AddInstruction(String name,CEInstruction instruction){
		if(instructionSet.containsKey(name)){
			throw new RuntimeException();
		}
		instructionSet.put(name,instruction);
	}
	
	public static void RemoveInstruction(String name){
		if(!instructionSet.containsKey(name)){
			throw new RuntimeException();
		}
		instructionSet.remove(name);
	}
	
	public static Object Execute(String name,String ...param){
		return instructionSet.get(name).Do(param);	
	}
}
