package Project.Character;

//ghost eatable feature not done

public abstract class Ghost {
    private int x = -1;
    private int y = -1;
    private int ghostMoveDelay;
    private boolean eatAble = false;
    private int ghostId;
    private int direction = 68;
    private boolean isCherry = false;
    private boolean isStrawberry = false;
    private boolean isCoin = false;
    //68   = d  right
    //65   = a  left
    //87   = w  up
    //83   = s  down
    private boolean isRoad = true;
    private boolean isNextCherry = false;
    private boolean isNextStrawberry = false;
    private boolean isNextCoin = false;
    //68   = d  right
    //65   = a  left
    //87   = w  up
    //83   = s  down
    private boolean isNextRoad = false;
    public void setIsNextRoad(boolean isRoad) {
        this.isNextRoad = isRoad;
    }
    public boolean getIsNextRoad() {
        return isNextRoad;
    }
    public void setIsNextCoin(boolean coin) {
        isNextCoin = coin;
    }

    public boolean getIsNextCoin(){
        return isNextCoin;
    }
    public void setIsNextCherry(boolean cherry) {
        isNextCherry = cherry;
    }

    public boolean getIsNextCherry(){
        return isNextCherry;
    }

    public boolean getIsNextStrawberry() {
        return isNextStrawberry;
    }

    public void setIsNextStrawberry(boolean isStrawberry) {
        this.isNextStrawberry = isStrawberry;
    }


    public void setIsRoad(boolean isRoad) {
        this.isRoad = isRoad;
    }
    public boolean getIsRoad() {
        return isRoad;
    }
    public void setIsCoin(boolean coin) {
        isCoin = coin;
    }

    public boolean getIsCoin(){
        return isCoin;
    }
    public void setIsCherry(boolean cherry) {
        isCherry = cherry;
    }

    public boolean getIsCherry(){
        return isCherry;
    }

    public boolean getIsStrawberry() {
        return isStrawberry;
    }

    public void setIsStrawberry(boolean isStrawberry) {
        this.isStrawberry = isStrawberry;
    }
    public void setEatAble(boolean eatAble) {
        this.eatAble = eatAble;
    }

    public Ghost( int moveDelay, int x, int y) {
        ghostMoveDelay = moveDelay;
        this.x = x;
        this.y = y;
    }

    public void getPlace(int[][] map) {}

    public int getGhostId() {

        return ghostId;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getGhostMoveDelay() {
        return ghostMoveDelay;
    }
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void move(int[][] map) {
    }





}
