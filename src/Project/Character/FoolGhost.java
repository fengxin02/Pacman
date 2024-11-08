package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


/*fool ghost goes in one direction, and when it hits wall it will change its direction with a
  random number generator and randomize his direction
 */
public class FoolGhost extends Ghost implements GameElement
{

    private BufferedImage GhostImage;

    public FoolGhost( int delay, int x , int y)
    {
        super(delay,x, y);
        try {
            GhostImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\ghost.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getPlace(int[][] map)
    {

        int id = getGhostId();
        int idstraw = getGhostId() + 7;
        int idcherry = getGhostId() + 4;
        int idcoin = getGhostId() + 1;
        for(int row = 0; row < map.length; row++)
        {
            for(int col = 0; col < map[row].length; col++)
            {
                if(map[row][col] == id || map[row][col] == idcherry || map[row][col] == idstraw || map[row][col] == idcoin )
                {
                    setX(col);
                    setY(row);
                }
            }
        }
    }
    //68   = d  right
    //65   = a  left
    //87   = w  up
//    //83   = s  down

    @Override
    public boolean collide(Wall wall) {
        return false;
    }

    @Override
    public boolean collide(FoolGhost ghost) {
        return false;
    }

    @Override
    public boolean collide(Pacman pacman) {
        pacman.setIsPacManAlive(false);
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
    public boolean checkDirec(Pacman pacman) {
        return true;
    }
    @Override
    public void paintImage(Graphics g, int x, int y, int cellheight, int cellwidth) {
        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
    }

    @Override
    public int getPoint() {
        return 0;
    }

    //kell
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

    @Override
    public int getMoveDelay() {
        return getGhostMoveDelay();
    }
}



//    public void move(int[][] map,int[] coordinate) {
//        int dir = getDirection();
//        //refresh the newest coordinate
//        getPlace(map);
//
//        int y = getY();
//        int x = getX();
//        int id = getGhostId();
//        if (dir == 68) //right
//        {
//            System.out.println("Ghost direction" + getDirection());
//            System.out.println("x " +getX());
//            System.out.println("y " + getY());
//            //if wall
//            if (map[y][x + 1] == 2)
//            {
//                Random rand = new Random();
//                int randomNum = rand.nextInt(3);
//                if (randomNum == 0)
//                {
//                    setDirection(65);
//                }
//                else if (randomNum == 1)
//                {
//                    setDirection(87);
//                }
//                else
//                {
//                    setDirection(83);
//                }
//            }
//            else
//            {
//                map[y][x] -= id;
//                map[y][x + 1] += id;
//                setY(y);
//                setX(x+1);
//                System.out.println("Ghost direction" + getDirection());
//                System.out.println("x " +getX());
//                System.out.println("y " + getY());
//            }
//        }
//        else if (dir == 65) //left
//        {
//            System.out.println("Ghost direction" + getDirection());
//            System.out.println("x " +getX());
//            System.out.println("y " + getY());
//            //if wall
//            if (map[y][x - 1] == 2)
//            {
//                Random rand = new Random();
//                int randomNum = rand.nextInt(3);
//                if (randomNum == 0)
//                {
//                    setDirection(68);
//                }
//                else if (randomNum == 1)
//                {
//                    setDirection(87);
//                }
//                else
//                {
//                    setDirection(83);
//                }
//
//            } else {
//                map[y][x] -= id;
//                map[y][x - 1] += id;
//                setY(y);
//                setX(x-1);
//                System.out.println("Ghost direction" + getDirection());
//                System.out.println("x " +getX());
//                System.out.println("y " + getY());
//            }
//        }
//        else if (dir == 87) //up
//        {
//            System.out.println("Ghost direction" + getDirection());
//            System.out.println("x " +getX());
//            System.out.println("y " + getY());
//
//            //if wall
//            if (map[y-1][x] == 2)
//            {
//                Random rand = new Random();
//                int randomNum = rand.nextInt(3);
//                if (randomNum == 0)
//                {
//                    setDirection(68);
//                }
//                else if (randomNum == 1)
//                {
//                    setDirection(65);
//                } else
//                {
//                    setDirection(83);
//                }
//            }
//            else
//            {
//                map[y][x] = map[y][x] - id;
//                map[y-1][x] = map[y-1][x] + id;
//                setY(y-1);
//                setX(x);
//                System.out.println("Ghost direction" + getDirection());
//                System.out.println("x " +getX());
//                System.out.println("y " + getY());
//            }
//
//
//        }
//        else if(dir == 83) //down
//        {
//            System.out.println("Ghost direction" + getDirection());
//            System.out.println("x " +getX());
//            System.out.println("y " + getY());
//            //if wall
//            if (map[y + 1][x] == 2)
//            {
//                Random rand = new Random();
//                int randomNum = rand.nextInt(3);
//                if (randomNum == 0)
//                {
//                    setDirection(68);
//                }
//                else if (randomNum == 1)
//                {
//                    setDirection(65);
//                }
//                else
//                {
//                    setDirection(87);
//                }
//            }
//            else
//            {
//                map[y][x] = map[y][x] - id;
//                map[y + 1][x] = map[y+1][x] + id;
//                setY(y+1);
//                setX(x);
//                System.out.println("Ghost direction" + getDirection());
//                System.out.println("x " +getX());
//                System.out.println("y " + getY());
//            }
//        }
//    }

