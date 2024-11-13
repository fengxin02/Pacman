package Project.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class TeleportGhost extends Ghost implements GameElement{

    private BufferedImage GhostImage;

    public TeleportGhost(int moveDelay, int x, int y) {
        super(moveDelay, x, y);
        try {
            GhostImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\telepghost.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
    public boolean collide(TeleportGhost ghost) {
        return false;
    }

    @Override
    public boolean collide(FastGhost ghost) {
        return false;
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

    @Override
    public int getMoveDelay() {
        return getGhostMoveDelay();
    }

    @Override
    public void move(GameElement[][] omap, int[] coordinate) {
        int x = this.getX();
        int y = this.getY();
        int dir = this.getDirection();

        Random rand = new Random();
        int randomX = rand.nextInt(12);
        int randomY = rand.nextInt(10);

        boolean moveable = omap[randomY][randomX].collide(this);
        while (!moveable) {
            randomX = rand.nextInt(12);
            randomY = rand.nextInt(10);
            moveable = omap[randomY][randomX].collide(this);
        }

        omap[randomY][randomX] = this;
        if (getIsCherry()) {
            omap[y][x] = new Cherry(200);
        } else if (getIsCoin()) {
            omap[y][x] = new Coin(10);
        } else if (getIsStrawberry()) {
            omap[y][x] = new Strawberry(100);
        } else if (getIsRoad()) {
            omap[y][x] = new Road();
        }
        this.setX(randomX);
        this.setY(randomY);
        coordinate[0] = randomX;
        coordinate[1] = randomY;

        setIsCherry(getIsNextCherry());
        setIsStrawberry(getIsNextStrawberry());
        setIsRoad(getIsNextRoad());
        setIsCoin(getIsNextCoin());

    }

}
