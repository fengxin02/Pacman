package Project.Main;

import Project.Frame.MenuFrame;

import javax.swing.*;

public class Main {

    public static void showMenu()
    {
        MenuFrame menu = new MenuFrame("PACMAN");
        menu.startSetUp();
    }


    public static void main(String[] args)
    {
        showMenu();

    }
}
