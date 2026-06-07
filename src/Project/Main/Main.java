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

    /**
     * Start up the menu
     * @param menu
     */
    public static void showMenu(MenuFrame menu)
    {
        menu.startSetUp();
    }

    /**
     * Load All Images
     */
    public static void loadImage(){
        String resPath = "src/Project/res/";
        try {
            TeleportGhostImage = ImageIO.read(new File(resPath + "telepghost.png"));
            CoinImage = ImageIO.read(new File(resPath + "coin.png"));
            WallImage = ImageIO.read(new File(resPath + "bricks-wall.png"));
            CherryImage = ImageIO.read(new File(resPath + "cherries.png"));
            FastGhostImage = ImageIO.read(new File(resPath + "fastghost.png"));
            FoolGhostImage = ImageIO.read(new File(resPath + "ghost.png"));
            PacmanLeftImage = ImageIO.read(new File(resPath + "pacmanleft.png"));
            PacmanUpImage = ImageIO.read(new File(resPath + "pacmanup.png"));
            PacmanDownImage = ImageIO.read(new File(resPath + "pacmandown.png"));
            PacmanRightImage = ImageIO.read(new File(resPath + "pacman.png"));
            StrawberryImage = ImageIO.read(new File(resPath + "strawberry.png"));
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
