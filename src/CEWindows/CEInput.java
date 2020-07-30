package CEWindows;

import java.util.*;

public class CEInput {

    public static int mouseX = 0; 
    public static int mouseY = 0; 

    static HashMap<Integer,Boolean> keyPressedMap = new HashMap<Integer,Boolean>();
    
    public static boolean IsKeyDown(int keycode){
        if (keyPressedMap.containsKey(keycode)) {
            return keyPressedMap.get(keycode);
        }
        return false;
    }
}