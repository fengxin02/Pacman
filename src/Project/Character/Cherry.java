package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Project.Main.Main.getCherryImage;

public class Cherry extends Fruit implements GameElement {
    private transient BufferedImage CherryImage;

    public Cherry(int score) {
        super(score);


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
    public boolean collide(FastGhost ghost) {
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
        CherryImage = getCherryImage();
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
