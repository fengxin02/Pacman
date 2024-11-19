package Project.Listener;

import Project.Character.GameElement;
import Project.Frame.MenuFrame;
import Project.Panel.GamePanel;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    /**
     * Main game panel
     */
    GamePanel gamePanel;
    /**
     * Game map
     */
    GameElement[][] map;
    /**
     * Menu main frame
     */
    MenuFrame menuFrame;
    public GameKeyListener(GamePanel gamePanel, GameElement[][]map, MenuFrame menuFrame)
    {

        this.menuFrame = menuFrame;
        this.gamePanel = gamePanel;
        this.map = map;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Return the pressed key and set the direction of Pacman
     * @param e the event to be processed
     */
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
            case 71:
                //save game
                gamePanel.saveGameState();
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
