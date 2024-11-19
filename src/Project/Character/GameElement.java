package Project.Character;


import java.awt.Graphics;

public interface GameElement {
    /**
     * Wall collide to implemented object
     * @param wall
     * @return Moveable or not
     */
    boolean collide(Wall wall);

    /**
     * Fool Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    boolean collide(FoolGhost ghost);

    /**
     * Pacman collide to implemented object
     * @param pacman
     * @return Moveable or not
     */
    boolean collide(Pacman pacman);

    /**
     * Teleport Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    boolean collide(TeleportGhost ghost);
    /**
     * Fast Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    boolean collide(FastGhost ghost);

    /**
     * Cherry collide to implemented object
     * @param cherry
     * @return Moveable or not
     */
    boolean collide(Cherry cherry);

    /**
     * Road collide to implemented object
     * @param road
     * @return Moveable
     */
    boolean collide(Road road);

    /**
     * Coin collide to implemented object
     * @param coin
     * @return Moveable or not
     */
    boolean collide(Coin coin);
    /**
     * Check if Pacman can change direction
     * @param pacman pacman
     * @return if Pacman can change direction
     */
    boolean checkDirec(Pacman pacman);

    /**
     * Draw implemented object picture
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    void paintImage(Graphics g, int x , int y, int cellheight, int cellwidth);

    /**
     * Get the current score
     * @return score
     */
    int getPoint();

    /**
     * Get currend direction
     * @return direction
     */
    int getDirection();

    /**
     * Set new direction
     * @param direction
     */
    void setDirection(int direction);

    /**
     * Get Move delay
     * @return mode delay
     */
    int getMoveDelay();

    /**
     * object moves
     * @param omap game map
     * @param coordinate object coordinates
     */
    void move(GameElement[][] omap,int[] coordinate);
}
