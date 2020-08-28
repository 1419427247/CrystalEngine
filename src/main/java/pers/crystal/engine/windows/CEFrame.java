package pers.crystal.engine.windows;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import pers.crystal.engine.application.CEInputManager;

/**
 * CEFrame
 */
public class CEFrame implements KeyListener, FocusListener, MouseListener, MouseMotionListener {
    private static JFrame frame = null;
    private static CEPanel panel = new CEPanel();
    private static GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice();

    public static void Create() {
        if (frame == null) {
            frame = new JFrame();

            CEFrame ceFrame = new CEFrame();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.addKeyListener(ceFrame);
            frame.addFocusListener(ceFrame);
            frame.addMouseListener(ceFrame);
            frame.addMouseMotionListener(ceFrame);

            frame.add(panel);
            frame.setSize(1024, 768);

            frame.setUndecorated(true);

            frame.setVisible(true);
            new Thread(new Runnable(){
                @Override
                public void run() {
                    while (true) {
                        panel.repaint();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public static void SetResizable(boolean resizable) {
        frame.setResizable(resizable);
    }

    public static void IsSetResizable() {
        frame.isResizable();
    }

    public static void SetFullScreenWindow(boolean fullScreenWindow) {
        graphicsDevice.setFullScreenWindow(fullScreenWindow == true ? frame : null);
    }

    public static boolean IsFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow() != null;
    }

    public static void Add(Component component) {
        frame.add(component);
    }

    public static void Remove(Component component) {
        frame.remove(component);
    }

    public static int GetWidth() {
        return frame.getWidth();
    }

    public static int GetHeight() {
        return frame.getHeight();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!CEInputManager.keyMap.containsKey(e.getKeyCode()) || CEInputManager.keyMap.get(e.getKeyCode()) == false) {
            CEInputManager.keyDownMap.put(e.getKeyCode(), true);
            CEInputManager.keyMap.put(e.getKeyCode(), true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        CEInputManager.keyMap.put(e.getKeyCode(), false);
        CEInputManager.keyUpMap.put(e.getKeyCode(), true);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        CEInputManager.keyMap.clear();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        CEInputManager.mouseX = e.getX();
        CEInputManager.mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        CEInputManager.mouseX = e.getX();
        CEInputManager.mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        CEInputManager.keyMap.put(e.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        CEInputManager.keyMap.put(e.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
