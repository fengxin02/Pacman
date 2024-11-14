package Project.Main;

import Project.Frame.MenuFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static BufferedImage CoinImage;
    public static BufferedImage WallImage;
    public static BufferedImage getCoinImage(){
        return CoinImage;
    }
    public static BufferedImage getWallImage(){
        return WallImage;
    }

    //calls the menu
    public static void showMenu(MenuFrame menu)
    {
        menu.startSetUp();
    }


    public static void loadImage(){
        try {
             CoinImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\coin.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            WallImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\bricks-wall.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {
        loadImage();
        MenuFrame menu = new MenuFrame("PACMAN");
        showMenu(menu);

    }
}
