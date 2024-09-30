package Project.Character;

public class Pacman {
    private int x = -1;
    private int y = -1;

    //68   = d  right
    //65   = a  left
    //87   = w  up
    //83   = s  down
    private int direction = 68;

    public Pacman() {}

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

    public void getPlace(int[][] map)
    {
        int i = 0;
        int j = 0;
        for(i = 0; i < map.length; i++)
        {
            for(j = 0; j < map[i].length; j++)
            {
                if(map[i][j] == 5)
                {
                    y = i;
                    x = j;
                    return;
                }
            }
        }
        x = -1;
        y = -1;
    }

}
