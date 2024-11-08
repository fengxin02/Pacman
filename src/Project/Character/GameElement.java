package Project.Character;

import java.awt.*;

public interface GameElement {
    boolean collide(Wall wall);
    boolean collide(FoolGhost ghost);
    boolean collide(Pacman pacman);

    boolean collide(Cherry cherry);
    boolean collide(Road road);
    boolean collide(Coin coin);
    boolean checkDirec(Pacman pacman);
    void paintImage(Graphics g,int x ,int y, int cellheight, int cellwidth);
    int getPoint();
    int getDirection();
    void setDirection(int direction);
    int getMoveDelay();
    void move(GameElement[][] omap,int[] coodinate);
}
