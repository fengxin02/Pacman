package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Project.Main.Main.getCherryImage;

public class Cherry extends Fruit implements GameElement {
    /**
     * Cherry Image
     */
    private transient BufferedImage CherryImage;

    public Cherry(int score) {
        super(score);


    }


    /**
     * Wall collide to implemented object
     * @param wall
     * @return Moveable or not
     */
    @Override
    public boolean collide(Wall wall) {
        return true;
    }
    /**
     * Fool Ghost collide to implemented object, and set the status
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FoolGhost ghost) {
        ghost.setIsNextCoin(false);
        ghost.setIsNextStrawberry(false);
        ghost.setIsNextCherry(true);
        ghost.setIsNextRoad(false);
        return true;
    }
    /**
     * Teleport Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(TeleportGhost ghost) {
        ghost.setIsNextCoin(false);
        ghost.setIsNextStrawberry(false);
        ghost.setIsNextCherry(true);
        ghost.setIsNextRoad(false);
        return true;
    }
    /**
     * Fast Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FastGhost ghost) {
        ghost.setIsNextCoin(false);
        ghost.setIsNextStrawberry(false);
        ghost.setIsNextCherry(true);
        ghost.setIsNextRoad(false);
        return true;
    }
    /**
     * Pacman collide to implemented object
     * @param pacman
     * @return Moveable or not
     */
    @Override
    public boolean collide(Pacman pacman) {
        pacman.addPoints(this.getScore());
        return true;
    }


    /**
     * Check if Pacman can change direction
     * @param pacman pacman
     * @return if Pacman can change direction
     */
    @Override
    public boolean checkDirec(Pacman pacman) {
        return true;
    }

    /**
     * Cherry collide to implemented object
     * @param cherry
     * @return Moveable or not
     */
    @Override
    public boolean collide(Cherry cherry) {
        return true;
    }
    /**
     * Road collide to implemented object
     * @param road
     * @return Moveable
     */
    @Override
    public boolean collide(Road road) {
        return true;
    }

    /**
     * Coin collide to implemented object
     * @param coin
     * @return Moveable or not
     */
    @Override
    public boolean collide(Coin coin) {
        return true;
    }
    /**
     * Draw cherry
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        CherryImage = getCherryImage();
        g.drawImage(CherryImage, x, y, cellwidth, cellheight, null);
    }
    /**
     * Get the current score
     * @return score
     */
    @Override
    public int getPoint() {
        return 0;
    }
    /**
     * Get currend direction
     * @return direction
     */
    @Override
    public int getDirection() {
        return 0;
    }
    /**
     * Set new direction
     * @param direction
     */
    @Override
    public void setDirection(int direction) {

    }
    /**
     * Get Move delay
     * @return mode delay
     */
    @Override
    public int getMoveDelay() {
        return 0;
    }
    /**
     * object moves
     * @param omap game map
     * @param coordinate object coordinates
     */
    @Override
    public void move(GameElement[][] omap,int[] coordinate) {
    }
}
