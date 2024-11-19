package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static Project.Main.Main.getTeleportGhostImage;

public class TeleportGhost extends Ghost implements GameElement{
    /**
     * Image of Teleport Ghost
     */
    private transient BufferedImage GhostImage;

    public TeleportGhost(int moveDelay, int x, int y) {
        super(moveDelay, x, y);
    }
    /**
     * Wall collide to implemented object
     * @param wall
     * @return Moveable or not
     */
    @Override
    public boolean collide(Wall wall) {
        return false;
    }
    /**
     * Fool Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FoolGhost ghost) {
        return false;
    }
    /**
     * Pacman collide to implemented object
     * @param pacman
     * @return Moveable or not
     */
    @Override
    public boolean collide(Pacman pacman) {
        pacman.setIsPacManAlive(false);
        return true;
    }
    /**
     * Teleport Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(TeleportGhost ghost) {
        return false;
    }
    /**
     * Fast Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FastGhost ghost) {
        return false;
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
     * Check if Pacman can change direction
     * @param pacman pacman
     * @return if Pacman can change direction
     */
    @Override
    public boolean checkDirec(Pacman pacman) {
        return true;
    }
    /**
     * Draw Teleport Ghost picture
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        GhostImage = getTeleportGhostImage();

        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
    }

    @Override
    public int getPoint() {
        return 0;
    }

    @Override
    public int getMoveDelay() {
        return getGhostMoveDelay();
    }
    /**
     * object moves
     * @param omap game map
     * @param coordinate object coordinates
     */
    @Override
    public void move(GameElement[][] omap, int[] coordinate) {
        int x = this.getX();
        int y = this.getY();
        int dir = this.getDirection();

        Random rand = new Random();
        int randomX = rand.nextInt(12);
        int randomY = rand.nextInt(10);

        boolean moveable = omap[randomY][randomX].collide(this);
        while (!moveable) {
            randomX = rand.nextInt(12);
            randomY = rand.nextInt(10);
            moveable = omap[randomY][randomX].collide(this);
        }

        omap[randomY][randomX] = this;
        if (getIsCherry()) {
            omap[y][x] = new Cherry(200);
        } else if (getIsCoin()) {
            omap[y][x] = new Coin(10);
        } else if (getIsStrawberry()) {
            omap[y][x] = new Strawberry(100);
        } else if (getIsRoad()) {
            omap[y][x] = new Road();
        }
        this.setX(randomX);
        this.setY(randomY);
        coordinate[0] = randomX;
        coordinate[1] = randomY;

        setIsCherry(getIsNextCherry());
        setIsStrawberry(getIsNextStrawberry());
        setIsRoad(getIsNextRoad());
        setIsCoin(getIsNextCoin());

    }

}
