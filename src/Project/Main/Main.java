package Project.Main;

import Project.Character.FastGhost;
import Project.Character.TeleportGhost;
import Project.Frame.MenuFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static BufferedImage CoinImage;
    public static BufferedImage WallImage;
    public static BufferedImage CherryImage;
    public static BufferedImage FastGhostImage;
    public static BufferedImage FoolGhostImage;
    public static BufferedImage PacmanRightImage;
    public static BufferedImage PacmanLeftImage;
    public static BufferedImage PacmanUpImage;
    public static BufferedImage PacmanDownImage;
    public static BufferedImage StrawberryImage;
    public static BufferedImage TeleportGhostImage;

    public static BufferedImage getTeleportGhostImage(){
        return TeleportGhostImage;
    }
    public static BufferedImage getStrawberryImage(){
       return StrawberryImage;
    }

    public static BufferedImage getPacmanRightImage(){
        return PacmanRightImage;
    }
    public static BufferedImage getPacmanLeftImage(){
        return PacmanLeftImage;
    }
    public static BufferedImage getPacmanUpImage(){
        return PacmanUpImage;
    }
    public static BufferedImage getPacmanDownImage(){
        return PacmanDownImage;
    }


    public static BufferedImage getFoolGhostImage(){
        return FoolGhostImage;
    }
    public static BufferedImage getFastGhostImage(){
        return FastGhostImage;
    }
    public static BufferedImage getCoinImage(){
        return CoinImage;
    }
    public static BufferedImage getWallImage(){
        return WallImage;
    }
    public static BufferedImage getCherryImage(){
        return CherryImage;
    }

    //calls the menu
    public static void showMenu(MenuFrame menu)
    {
        menu.startSetUp();
    }


    public static void loadImage(){
        try {
            TeleportGhostImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\telepghost.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        try {
            CherryImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\cherries.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FastGhostImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\fastghost.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FoolGhostImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\ghost.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            PacmanLeftImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacmanleft.png"));
            PacmanUpImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacmanup.png"));
            PacmanDownImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacmandown.png"));
            PacmanRightImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacman.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            StrawberryImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\strawberry.png"));

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
