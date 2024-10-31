package Project.Character;

import java.awt.*;

public class Road implements GameElement{

    @Override
    public boolean collide(Wall wall) {
        return true;
    }

    @Override
    public boolean collide(FoolGhost ghost) {
        return true;
    }

    @Override
    public boolean collide(Pacman pacman) {
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
    }

    @Override
    public int getPoint() {
        return 0;
    }

    @Override
    public int getDirection() {
        return 0;
    }

    @Override
    public void setDirection(int direction) {

    }

    @Override
    public int getMoveDelay() {
        return 0;
    }

    @Override
    public void move(GameElement[][] omap,int[] coordinate) {

    }
}
