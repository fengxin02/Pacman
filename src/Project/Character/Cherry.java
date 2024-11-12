package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cherry extends Fruit implements GameElement {
    private BufferedImage CherryImage;

    public Cherry(int score) {
        super(score);

        try {
            CherryImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\cherries.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public boolean collide(Wall wall) {
        return true;
    }

    @Override
    public boolean collide(FoolGhost ghost) {
        ghost.setIsNextCoin(false);
        ghost.setIsNextStrawberry(false);
        ghost.setIsNextCherry(true);
        ghost.setIsNextRoad(false);
        return true;
    }

    @Override
    public boolean collide(TeleportGhost ghost) {
        ghost.setIsNextCoin(false);
        ghost.setIsNextStrawberry(false);
        ghost.setIsNextCherry(true);
        ghost.setIsNextRoad(false);
        return true;
    }

    @Override
    public boolean collide(Pacman pacman) {
        pacman.addPoints(this.getScore());
        return true;
    }



    @Override
    public boolean checkDirec(Pacman pacman) {
        return true;
    }


    @Override
    public boolean collide(Cherry cherry) {
        return true;
    }

    @Override
    public boolean collide(Road road) {
        return true;
    }


    @Override
    public boolean collide(Coin coin) {
        return true;
    }

    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        g.drawImage(CherryImage, x, y, cellwidth, cellheight, null);
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
    public void move(GameElement[][] omap,int[] coordinate) {
    }
}
