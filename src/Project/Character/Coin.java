package Project.Character;
import java.awt.*;
import java.awt.image.BufferedImage;


import static Project.Main.Main.getCoinImage;

public class Coin implements GameElement{
    /**
     * The value of the coin
     */
    private int score;
    /**
     * Coin Image
     */
    private transient BufferedImage CoinImage;

    public Coin(int score) {
        this.score = score;

    }

    /**
     * Get the value of the coin
     * @return value
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the value of the coin
     * @param score value
     */
    public void setScore(int score) {
        this.score = score;
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
     * Fool Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FoolGhost ghost) {
        ghost.setIsNextCoin(true);
        ghost.setIsNextCherry(false);
        ghost.setIsNextStrawberry(false);
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
        pacman.addPoints(getScore());
        return true;
    }
    /**
     * Teleport Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(TeleportGhost ghost) {
        ghost.setIsNextCoin(true);
        ghost.setIsNextCherry(false);
        ghost.setIsNextStrawberry(false);
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
        ghost.setIsNextCoin(true);
        ghost.setIsNextCherry(false);
        ghost.setIsNextStrawberry(false);
        ghost.setIsNextRoad(false);
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
     * Check if Pacman can change direction
     * @param pacman pacman
     * @return if Pacman can change direction
     */
    @Override
    public boolean checkDirec(Pacman pacman) {
        return true;
    }
    /**
     * Draw coin picture
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        CoinImage = getCoinImage();
        g.drawImage(CoinImage, x, y, cellwidth, cellheight, null);
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
