package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Wall implements GameElement {

    private BufferedImage WallImage;
    public Wall() {
        try {
            WallImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\bricks-wall.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean collide(Wall wall) {
        return false;
    }

    @Override
    public boolean collide(FoolGhost ghost) {
        return false;
    }
    @Override
    public boolean checkDirec(Pacman pacman) {
        return false;
    }
    @Override
    public boolean collide(Pacman pacman) {
        return false;
    }

    @Override
    public boolean collide(TeleportGhost ghost) {
        return false;
    }

    @Override
    public boolean collide(Cherry cherry) {
        return false;
    }

    @Override
    public boolean collide(Road road) {
        return false;
    }



    @Override
    public boolean collide(Coin coin) {
        return false;
    }

    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        g.drawImage(WallImage, x, y, cellwidth, cellheight, null);
    }

    @Override
    public int getPoint() {
        return 0;
    }

    @Override
    public int getDirection() {
        return 0;
    }

    @Override
    public void setDirection(int direction) {

    }

    @Override
    public int getMoveDelay() {
        return 0;
    }

    @Override
    public void move(GameElement[][] omap ,int[] coordinate) {

    }
}
