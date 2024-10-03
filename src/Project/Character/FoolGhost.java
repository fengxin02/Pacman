package Project.Character;

import java.util.Random;


/*fool ghost goes in one direction, and when it hits wall it will change its direction with a
  random number generator and randomize his direction
 */
public class FoolGhost extends Ghost
{
    public FoolGhost(int id, int delay)
    {
        super(id, delay);
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
    //83   = s  down
    public void move(int[][] map) {
        int dir = getDirection();
        //refresh the newest coordinate
        getPlace(map);

        int y = getY();
        int x = getX();
        int id = getGhostId();
        if (dir == 68) //right
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());
            //if wall
            if (map[y][x + 1] == 2)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt(3);
                if (randomNum == 0)
                {
                    setDirection(65);
                }
                else if (randomNum == 1)
                {
                    setDirection(87);
                }
                else
                {
                    setDirection(83);
                }
            }
            else
            {
                map[y][x] -= id;
                map[y][x + 1] += id;
                setY(y);
                setX(x+1);
                System.out.println("Ghost direction" + getDirection());
                System.out.println("x " +getX());
                System.out.println("y " + getY());
            }
        }
        else if (dir == 65) //left
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());
            //if wall
            if (map[y][x - 1] == 2)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt(3);
                if (randomNum == 0)
                {
                    setDirection(68);
                }
                else if (randomNum == 1)
                {
                    setDirection(87);
                }
                else
                {
                    setDirection(83);
                }

            } else {
                map[y][x] -= id;
                map[y][x - 1] += id;
                setY(y);
                setX(x-1);
                System.out.println("Ghost direction" + getDirection());
                System.out.println("x " +getX());
                System.out.println("y " + getY());
            }
        }
        else if (dir == 87) //up
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());

            //if wall
            if (map[y-1][x] == 2)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt(3);
                if (randomNum == 0)
                {
                    setDirection(68);
                }
                else if (randomNum == 1)
                {
                    setDirection(65);
                } else
                {
                    setDirection(83);
                }
            }
            else
            {
                map[y][x] = map[y][x] - id;
                map[y-1][x] = map[y-1][x] + id;
                setY(y-1);
                setX(x);
                System.out.println("Ghost direction" + getDirection());
                System.out.println("x " +getX());
                System.out.println("y " + getY());
            }


        }
        else if(dir == 83) //down
        {
            System.out.println("Ghost direction" + getDirection());
            System.out.println("x " +getX());
            System.out.println("y " + getY());
            //if wall
            if (map[y + 1][x] == 2)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt(3);
                if (randomNum == 0)
                {
                    setDirection(68);
                }
                else if (randomNum == 1)
                {
                    setDirection(65);
                }
                else
                {
                    setDirection(87);
                }
            }
            else
            {
                map[y][x] = map[y][x] - id;
                map[y + 1][x] = map[y+1][x] + id;
                setY(y+1);
                setX(x);
                System.out.println("Ghost direction" + getDirection());
                System.out.println("x " +getX());
                System.out.println("y " + getY());
            }
        }
    }



}
