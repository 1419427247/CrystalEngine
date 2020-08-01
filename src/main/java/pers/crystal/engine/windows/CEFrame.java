package pers.crystal.engine.windows;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/**
 * CEFrame
 */
public class CEFrame implements KeyListener, FocusListener, MouseListener, MouseMotionListener, Runnable {
    private JFrame frame = new JFrame();
    private CEPanel panel = new CEPanel();
    private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public CEFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(this);
        frame.addFocusListener(this);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);

        frame.add(panel);
        frame.setSize(1024, 768);
        frame.setVisible(true);
        new Thread(this).start();
    }


    public void SetResizable(boolean resizable){
        frame.setResizable(resizable);
    }
    public void IsSetResizable(){
        frame.isResizable();
    }

    public void SetUndecorated(boolean undecorated){
        frame.setUndecorated(undecorated);
    }

    public void IsUndecorated(boolean undecorated){
        frame.isUndecorated();
    }

    public void SetFullScreenWindow(boolean fullScreenWindow){
        graphicsDevice.setFullScreenWindow(fullScreenWindow == true ? frame : null );
    }

    public boolean IsFullScreenWindow(){
        return graphicsDevice.getFullScreenWindow() != null;
    } 

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

    @Override
    public synchronized void keyTyped(KeyEvent e) {

    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        CEInput.keyPressedMap.put(e.getKeyCode(), true);
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        CEInput.keyPressedMap.put(e.getKeyCode(), false);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        CEInput.keyPressedMap.clear();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        CEInput.mouseX = e.getX();
        CEInput.mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        CEInput.mouseX = e.getX();
        CEInput.mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        CEInput.keyPressedMap.put(e.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        CEInput.keyPressedMap.put(e.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
