package Project.Listener;

import Project.Character.GameElement;
import Project.Frame.MenuFrame;
import Project.Panel.GamePanel;
import Project.SaveGame.SaveMap;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    GamePanel gamePanel;
    GameElement[][] map;
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
            
                //bullshit delete this
                //g = save the map
            case 71:
                //save game
                gamePanel.removeAll();
                gamePanel.revalidate();
                gamePanel.repaint();
                menuFrame.remove(gamePanel);

                SaveMap s = new SaveMap(map,menuFrame);
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
