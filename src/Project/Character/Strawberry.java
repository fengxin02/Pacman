package Project.Character;

import java.awt.*;
import java.awt.image.BufferedImage;


import static Project.Main.Main.getStrawberryImage;

public class Strawberry extends Fruit implements GameElement{
    /**
     * Image of Strawberry
     */
    private transient BufferedImage StrawberryImage;


    public Strawberry(int score) {
        super(score);
    }
    /**
     * Pacman collide to implemented object
     * @param pacman
     * @return Moveable or not
     */
    @Override
    public boolean checkDirec(Pacman pacman) {
        return true;
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
        ghost.setIsNextStrawberry(true);
        ghost.setIsNextCoin(false);
        ghost.setIsNextCherry(false);
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
     * Teleport Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(TeleportGhost ghost) {
        ghost.setIsNextStrawberry(true);
        ghost.setIsNextCoin(false);
        ghost.setIsNextCherry(false);
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
        ghost.setIsNextStrawberry(true);
        ghost.setIsNextCoin(false);
        ghost.setIsNextCherry(false);
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
     * Draw Strawberry picture
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        StrawberryImage = getStrawberryImage();

        g.drawImage(StrawberryImage, x, y, cellwidth, cellheight, null);
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
    /**
     * object moves
     * @param map game map
     * @param coordinate object coordinates
     */
    @Override
    public void move(GameElement[][] map,int[] coordinate) {

    }
}
