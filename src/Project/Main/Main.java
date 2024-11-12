package Project.Main;

import Project.Frame.MenuFrame;

import javax.swing.*;

public class Main {

    //calls the menu
    public static void showMenu(MenuFrame menu)
    {
        menu.startSetUp();
    }


    public static void main(String[] args)
    {
        MenuFrame menu = new MenuFrame("PACMAN");
        showMenu(menu);

    }
}
