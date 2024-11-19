package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Project.Main.Main.getWallImage;

public class Wall implements GameElement {

    /**
     * Image for wall
     */
    private transient BufferedImage WallImage;
    public Wall() {
//        try {
//            WallImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\bricks-wall.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    /**
     * Wall collide to wall
     * @param wall wall
     * @return Moveable or not
     */
    @Override
    public boolean collide(Wall wall) {
        return false;
    }

    /**
     * Fool ghost collide to wall
     * @param ghost fool ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FoolGhost ghost) {
        return false;
    }

    /**
     * Check if Pacman can change direction
     * @param pacman pacman
     * @return if Pacman can change direction
     */
    @Override
    public boolean checkDirec(Pacman pacman) {
        return false;
    }

    /**
     * Pacman collide to wall
     * @param pacman pacman
     * @return Moveable or not
     */
    @Override
    public boolean collide(Pacman pacman) {
        return false;
    }

    /**
     * Teleport ghost collide to wall
     * @param ghost teleport ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(TeleportGhost ghost) {
        return false;
    }

    /**
     * Fast ghost collide to wall
     * @param ghost fast ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FastGhost ghost) {
        return false;
    }

    /**
     * Cherry collide to wall
     * @param cherry cherry
     * @return Moveable or not
     */
    @Override
    public boolean collide(Cherry cherry) {
        return false;
    }

    /**
     * Road collide to wall
     * @param road road
     * @return Moveable or not
     */
    @Override
    public boolean collide(Road road) {
        return false;
    }


    /**
     * Coin collide to wall
     * @param coin coin
     * @return Moveable or not
     */
    @Override
    public boolean collide(Coin coin) {
        return false;
    }

    /**
     * Draw wall picture
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        WallImage = getWallImage();

        g.drawImage(WallImage, x, y, cellwidth, cellheight, null);
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
    public void move(GameElement[][] omap ,int[] coordinate) {

    }
}
