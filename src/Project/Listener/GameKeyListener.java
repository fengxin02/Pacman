package Project.Listener;

import Project.Panel.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    GamePanel gamePanel;

    public GameKeyListener(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(e.getKeyChar() + " " +e.getKeyCode());
        //68   = d  right
        //65   = a  left
        //87   = w  up
        //83   = s  down
        switch (key)
        {
            case 87:
                gamePanel.setDirection(87);
                break;
            case 65:
                gamePanel.setDirection(65);
                break;
            case 83:
                gamePanel.setDirection(83);
                break;
            case 68:
                gamePanel.setDirection(68);
                break;
            default:

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
