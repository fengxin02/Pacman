package Project.SaveGame;

import Project.Character.GameElement;
import Project.Frame.MenuFrame;
import Project.Layout.MenuLayout;
import Project.Panel.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Project.Main.Main.showMenu;

//saves the game to JSON
public class SaveMap {
    private MenuFrame menu;
    public SaveMap(GameElement[][] map, MenuFrame menuFrame) {
        menu = menuFrame;
        // save somehow




        //end the game with first elem be null
        map[0][0] = null;
        showMenu(menu);

    }
}
