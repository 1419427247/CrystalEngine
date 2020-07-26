package CEWindows;

import javax.swing.*;

import CEUtility.CETime;

import java.awt.event.*;

/**
 * CEFrame
 */
public class CEFrame extends JFrame
        implements KeyListener, FocusListener, MouseListener, MouseMotionListener, Runnable {
    public CEPanel panel = new CEPanel();

    public CEFrame() {
        this.addKeyListener(this);
        this.addFocusListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.add(panel);

        this.setSize(1024, 768);
        this.setVisible(true);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            panel.repaint();
        }
    }

    @Override
    public synchronized void keyTyped(KeyEvent e){
        
    }

    @Override
    public synchronized void keyPressed(KeyEvent e){
        CEInput.keyPressedMap.put(e.getKeyCode(),true);
    }
    
    @Override
    public synchronized void keyReleased(KeyEvent e){
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
