package Project.Character;

//ghost eatable feature not done

public abstract class Ghost {
    private int x = -1;
    private int y = -1;
    private int ghostMoveDelay;
    private boolean eatAble = false;
    private int ghostId;
    private int direction = 68;

    //68   = d  right
    //65   = a  left
    //87   = w  up
    //83   = s  down

    public void setEatAble(boolean eatAble)
    {
        this.eatAble = eatAble;
    }

    public Ghost(int id, int moveDelay)
    {
        ghostMoveDelay = moveDelay;
        ghostId = id;
    }

    public void getPlace(int[][] map) {}

    public int getGhostId()
    {

        return ghostId;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }


    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getGhostMoveDelay()
    {
        return ghostMoveDelay;
    }
    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public void move(int[][] map){}





}
