package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static Project.Main.Main.getFoolGhostImage;


/*fool ghost goes in one direction, and when it hits wall it will change its direction with a
  random number generator and randomize his direction
 */
public class FoolGhost extends Ghost implements GameElement
{
    /**
     * Fool Ghost image
     */
    private transient BufferedImage GhostImage;

    public FoolGhost( int delay, int x , int y)
    {
        super(delay,x, y);

    }
    //68   = d  right
    //65   = a  left
    //87   = w  up
//    //83   = s  down
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
     * Draw Fool Ghost picture
     * @param g Graphics
     * @param x x coordinate where to draw
     * @param y y coordinate where to draw
     * @param cellheight
     * @param cellwidth
     */
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        GhostImage = getFoolGhostImage();
        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
    }

    @Override
    public int getPoint() {
        return 0;
    }

    /**
     * Fool Ghost moves
     * @param omap game map
     * @param coordinate object coordinates
     */
    @Override
    public void move(GameElement[][] omap,int[] coordinate) {
        int x = this.getX();
        int y = this.getY();
        int dir = this.getDirection();

        if (dir == 68) //right
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());
            //if wall
            boolean moveable = omap[y][x+1].collide(this);
            if(moveable){
                omap[y][x+1] = this;
                this.setX(x+1);
                coordinate[0] = x+1;
                if(getIsCherry()){
                    omap[y][x] = new Cherry(200);
                } else if (getIsCoin()) {
                    omap[y][x] = new Coin(10);
                }else if (getIsStrawberry()){
                    omap[y][x] = new Strawberry(100);
                }else if (getIsRoad()){
                    omap[y][x] = new Road();
                }
            }else {
                Random rand = new Random();
                int randomNum = rand.nextInt(4);
                if (randomNum == 0) {
                    setDirection(65);
                } else if (randomNum == 1) {
                    setDirection(87);
                } else if (randomNum == 2){
                    setDirection(83);
                } else {
                    setDirection(68);
                }
            }
        }
        else if (dir == 65) //left
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());
            //if wall
            boolean moveable = omap[y][x-1].collide(this);
            if(moveable){
                omap[y][x-1] = this;
                this.setX(x-1);
                coordinate[0] = x-1;
                if(getIsCherry()){
                    omap[y][x] = new Cherry(200);
                } else if (getIsCoin()) {
                    omap[y][x] = new Coin(10);
                }else if (getIsStrawberry()){
                    omap[y][x] = new Strawberry(100);
                }else if (getIsRoad()){
                    omap[y][x] = new Road();
                }
            }else {
                Random rand = new Random();
                int randomNum = rand.nextInt(4);
                if (randomNum == 0) {
                    setDirection(65);
                } else if (randomNum == 1) {
                    setDirection(87);
                } else if (randomNum == 2){
                    setDirection(83);
                } else {
                    setDirection(68);
                }
            }
        }
        else if (dir == 87) //up
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());
            //if wall
            boolean moveable = omap[y-1][x].collide(this);
            if(moveable){
                omap[y-1][x] = this;
                this.setY(y-1);
                coordinate[1] = y-1;
                if(getIsCherry()){
                    omap[y][x] = new Cherry(200);
                } else if (getIsCoin()) {
                    omap[y][x] = new Coin(10);
                }else if (getIsStrawberry()){
                    omap[y][x] = new Strawberry(100);
                }else if (getIsRoad()){
                    omap[y][x] = new Road();
                }
            }else {
                Random rand = new Random();
                int randomNum = rand.nextInt(4);
                if (randomNum == 0) {
                    setDirection(65);
                } else if (randomNum == 1) {
                    setDirection(87);
                } else if (randomNum == 2){
                    setDirection(83);
                } else {
                    setDirection(68);
                }
            }
        }
        else if(dir == 83) //down
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());
            //if wall
            boolean moveable = omap[y+1][x].collide(this);
            if(moveable){
                omap[y+1][x] = this;
                this.setY(y+1);
                coordinate[1] = y+1;
                if(getIsCherry()){
                    omap[y][x] = new Cherry(200);
                } else if (getIsCoin()) {
                    omap[y][x] = new Coin(10);
                }else if (getIsStrawberry()){
                    omap[y][x] = new Strawberry(100);
                }else if (getIsRoad()){
                    omap[y][x] = new Road();
                }
            }else {
                Random rand = new Random();
                int randomNum = rand.nextInt(4);
                if (randomNum == 0) {
                    setDirection(65);
                } else if (randomNum == 1) {
                    setDirection(87);
                } else if (randomNum == 2){
                    setDirection(83);
                } else {
                    setDirection(68);
                }
            }
        }
        setIsCherry(getIsNextCherry());
        setIsStrawberry(getIsNextStrawberry());
        setIsRoad(getIsNextRoad());
        setIsCoin(getIsNextCoin());
    }
    /**
     * Get Move delay
     * @return mode delay
     */
    @Override
    public int getMoveDelay() {
        return getGhostMoveDelay();
    }
}
