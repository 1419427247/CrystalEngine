package pers.crystal.engine.application;

import java.util.HashMap;

public class CEInputManager extends CEBehave {

    public static int mouseX = 0;
    public static int mouseY = 0;

    public static HashMap<Integer, Boolean> keyMap = new HashMap<Integer, Boolean>();
    public static HashMap<Integer, Boolean> keyDownMap = new HashMap<Integer, Boolean>();
    public static HashMap<Integer, Boolean> keyUpMap = new HashMap<Integer, Boolean>();

    @Override
    protected void Start() {

    }

    @Override
    protected void Update() {
        keyUpMap.clear();
        keyDownMap.clear();
    }

    @Override
    protected void Destroy() {

    }

    public static boolean GetKey(int keycode) {
        if (keyMap.containsKey(keycode)) {
            return keyMap.get(keycode);
        }
        return false;
    }

    public static boolean GetKeyDown(int keycode) {
        if (keyDownMap.containsKey(keycode)) {
            return keyDownMap.get(keycode);
        }
        return false;
    }

    public static boolean GetKeyUp(int keycode) {
        if (keyUpMap.containsKey(keycode)) {
            return keyUpMap.get(keycode);
        }
        return false;
    }
}