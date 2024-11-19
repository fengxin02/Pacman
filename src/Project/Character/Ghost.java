package Project.Character;

//ghost eatable feature not done

public abstract class Ghost {
    /**
     * X coordinate of the Ghost
     */
    private int x = -1;
    /**
     * Y coordinate of the Ghost
     */
    private int y = -1;
    /**
     * Move Delay of the Ghost
     */
    private int ghostMoveDelay;
    /**
     * Direction of the Ghost
     */
    private int direction = 68;
    /**
     * Was cherry under Ghost
     */
    private boolean isCherry = false;
    /**
     * Was strawberry under Ghost
     */
    private boolean isStrawberry = false;
    /**
     * Was coin under Ghost
     */
    private boolean isCoin = false;
    /**
     * Was road under Ghost
     */
    private boolean isRoad = true;
    /**
     * Is next cherry
     */
    private boolean isNextCherry = false;
    /**
     * Is next strawberry
     */
    private boolean isNextStrawberry = false;
    /**
     * Is next coin
     */
    private boolean isNextCoin = false;
    /**
     * Is next road
     */
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

    /**
     * Constructor
     * @param moveDelay
     * @param x
     * @param y
     */
    public Ghost( int moveDelay, int x, int y) {
        ghostMoveDelay = moveDelay;
        this.x = x;
        this.y = y;
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
