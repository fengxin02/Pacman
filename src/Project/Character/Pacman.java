package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Project.Main.Main.*;

public class Pacman implements GameElement{
    //coordinate of pacman
    private int x = 4; //4
    private int y = 6;//6

    private int points = 0;
    private int PacManMoveDelay = 1;
    private transient BufferedImage PacmanRightImage;
    private transient BufferedImage PacmanLeftImage;
    private transient BufferedImage PacmanUpImage;
    private transient BufferedImage PacmanDownImage;
    private boolean isPacManAlive = true;
    //68   = d  right
    //65   = a  left
    //87   = w  up
    //83   = s  down
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


    @Override
    public boolean collide(Wall wall) {
        return false;
    }

    @Override
    public boolean collide(FoolGhost ghost) {
        isPacManAlive = false;
        return true;
    }

    @Override
    public boolean collide(Pacman pacman) {
        return false;
    }

    @Override
    public boolean collide(TeleportGhost ghost) {
        isPacManAlive = false;
        return true;
    }

    @Override
    public boolean collide(FastGhost ghost) {
        isPacManAlive = false;
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
    @Override
    public boolean checkDirec(Pacman pacman) {
        return true;
    }

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
                    coordinate[0] = -1;
                    coordinate[1] = -1;
                }

            }
        }

    }

}
