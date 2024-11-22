package Project.Character;
import java.awt.*;
import java.awt.image.BufferedImage;


import static Project.Main.Main.*;

public class Pacman implements GameElement{
    //coordinate of pacman
    /***
     * X coordinate of Pacman
     */
    private int x = 4;//4
    /**
     * Y coordinate of Pacman
     */
    private int y = 6;//6

    /**
     * Score
     */
    private int points = 0;
    /**
     * Move Delay of Pacman
     */
    private int PacManMoveDelay = 1;
    /**
     * Image of Pacman
     */
    private transient BufferedImage PacmanRightImage;
    /**
     * Image of Pacman
     */
    private transient BufferedImage PacmanLeftImage;
    /**
     * Image of Pacman
     */
    private transient BufferedImage PacmanUpImage;
    /**
     * Image of Pacman
     */
    private transient BufferedImage PacmanDownImage;
    /**
     * Is Pacman Alive
     */
    private boolean isPacManAlive = true;
    //68   = d  right
    //65   = a  left
    //87   = w  up
    //83   = s  down
    /**
     * Direction of Pacman
     */
    private int direction = 68;

    public Pacman(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setIsPacManAlive(boolean isPacManAlive) {
        this.isPacManAlive = isPacManAlive;
    }
    public boolean isPacManAlive() {
        return isPacManAlive;
    }

    /**
     * Add points to the score
     * @param points
     */
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int getMoveDelay()
    {
        return PacManMoveDelay;
    }


    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    public int getDirection()
    {
        return direction;
    }
    public void setDirection(int direction)
    {
        this.direction = direction;
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
        isPacManAlive = false;
        return true;
    }
    /**
     * Pacman collide to implemented object
     * @param pacman
     * @return Moveable or not
     */
    @Override
    public boolean collide(Pacman pacman) {
        return false;
    }
    /**
     * Teleport Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(TeleportGhost ghost) {
        isPacManAlive = false;
        return true;
    }
    /**
     * Fast Ghost collide to implemented object
     * @param ghost
     * @return Moveable or not
     */
    @Override
    public boolean collide(FastGhost ghost) {
        isPacManAlive = false;
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
     * Draw Pacman picture
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        PacmanLeftImage = getPacmanLeftImage();
        PacmanRightImage = getPacmanRightImage();
        PacmanDownImage = getPacmanDownImage();
        PacmanUpImage = getPacmanUpImage();
        if (getDirection() == 65) {
            g.drawImage(PacmanLeftImage, x, y, cellwidth, cellheight, null);
        }
        if (getDirection() == 87) {
            g.drawImage(PacmanUpImage, x, y, cellwidth, cellheight, null);
        }
        if (getDirection() == 83) {
            g.drawImage(PacmanDownImage, x, y, cellwidth, cellheight, null);
        }
        if (getDirection() == 68) {
            g.drawImage(PacmanRightImage, x, y, cellwidth, cellheight, null);
        }
    }

    @Override
    public int getPoint() {
        return points;
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
     * object Pacman moves
     * @param map game map
     * @param coordinate object coordinates
     */
    public void move(GameElement[][] map, int[]coordinate)
    {

        int x = this.getX();
        int y = this.getY();
        int direction = this.getDirection();
        //68   = d  right
        //65   = a  left
        //87   = w  up
        //83   = s  down
        if(direction == 68) //right
        {
            boolean moveable = map[y][x+1].collide(this);
            if(moveable){
                if(isPacManAlive)
                {
                    map[y][x+1] = this;
                    map[y][x] = new Road();
                    this.x = x+1;
                    coordinate[0] = x+1;
                }
                else{
                    map[y][x] = new Road();
                    coordinate[0] = -1;
                    coordinate[1] = -1;
                }

            }
        }

        if(direction == 65) //left
        {
            boolean moveable = map[y][x-1].collide(this);
            if(moveable){
                if(isPacManAlive)
                {
                    map[y][x-1] = this;
                    map[y][x] = new Road();
                    this.x = x-1;
                    coordinate[0] = x-1;
                }
                else{
                    map[y][x] = new Road();
                    coordinate[0] = -1;
                    coordinate[1] = -1;
                }

            }
        }

        if(direction == 87) //up
        {
            boolean moveable = map[y-1][x].collide(this);
            if(moveable){
                if(isPacManAlive)
                {
                    map[y-1][x] = this;
                    map[y][x] = new Road();
                    this.y = y-1;
                    coordinate[1] = y-1;
                }
                else{
                    map[y][x] = new Road();
                    coordinate[0] = -1;
                    coordinate[1] = -1;
                }

            }
        }

        if(direction == 83) //down
        {
            boolean moveable = map[y+1][x].collide(this);
            if(moveable){
                if(isPacManAlive)
                {
                    map[y+1][x] = this;
                    map[y][x] = new Road();
                    this.y = y+1;
                    coordinate[1] = y+1;
                }
                else{
                    map[y][x] = new Road();
                    coordinate[0] = -1;
                    coordinate[1] = -1;
                }

            }
        }

    }

}
