import Project.Character.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FoolGhostTest {

    private FoolGhost foolghost;
    private GameElement[][] omap = new GameElement[10][12];


    public void iniMap(GameElement[][] omap){
        //first row
        omap[0][0] = new Wall(); omap[0][1] = new Wall();
        omap[0][2] = new Wall(); omap[0][3] = new Wall();
        omap[0][4] = new Wall(); omap[0][5] = new Wall();
        omap[0][6] = new Wall(); omap[0][7] = new Wall();
        omap[0][8] = new Wall(); omap[0][9] = new Wall();
        omap[0][10] = new Wall(); omap[0][11] = new Wall();


        //second row 10coin
        omap[1][0] = new Wall(); omap[1][1] = new Coin(10);
        omap[1][2] = new Coin(10); omap[1][3] = new Coin(10);
        omap[1][4] = new Coin(10); omap[1][5] = new Coin(10);
        omap[1][6] = new Coin(10); omap[1][7] = new Coin(10);
        omap[1][8] = new Coin(10); omap[1][9] = new TeleportGhost(10,9,1);
        omap[1][10] =new Coin(10); omap[1][11] = new Wall();


        //third row 8coins
        omap[2][0] = new Wall();         omap[2][1] = new Coin(10);
        omap[2][2] = new Wall();         omap[2][3] = new Wall();
        omap[2][4] = new Coin(10); omap[2][5] = new Coin(10);
        omap[2][6] = new Coin(10); omap[2][7] = new Coin(10);
        omap[2][8] = new Coin(10); omap[2][9] = new FastGhost(1,9,2);
        omap[2][10] =new Coin(10); omap[2][11] = new Wall();


        //fourth row 3conis
        omap[3][0] = new Wall();         omap[3][1] = new Coin(10);
        omap[3][2] = new Coin(10); omap[3][3] = new Coin(10);
        omap[3][4] = new Wall();         omap[3][5] = new Wall();
        omap[3][6] = new Wall();         omap[3][7] = new Wall();
        omap[3][8] = new Wall();         omap[3][9] = new Wall();
        omap[3][10] =new Wall();         omap[3][11] = new Wall();


        //fifth row {2,1,2,2,2,2,2,2,1,1,1,2}, 3coins
        omap[4][0] = new Wall();         omap[4][1] = new Coin(10);
        omap[4][2] = new Wall();         omap[4][3] = new Wall();
        omap[4][4] = new Wall();         omap[4][5] = new Wall();
        omap[4][6] = new Wall();         omap[4][7] = new Wall();
        omap[4][8] = new Wall();         omap[4][9] = new Coin(10);
        omap[4][10] =new Coin(10); omap[4][11] = new Wall();

        //sixth row {2,1,1,2,1,1,20,1,1,1,1,2},8coins
        omap[5][0] = new Wall();         omap[5][1] = new Coin(10);
        omap[5][2] = new Coin(10); omap[5][3] = new Coin(10);
        omap[5][4] = new Wall();         omap[5][5] = new Coin(10);
        omap[5][6] = new Coin(10); omap[5][7] = foolghost;
        omap[5][8] = new Coin(10); omap[5][9] = new Coin(10);
        omap[5][10] =new Coin(10); omap[5][11] = new Wall();


        //seventh row {2,1,1,1,5,1,1,4,7,2,1,2}, 6coin, 1strawberry,1cherry
        omap[6][0] = new Wall();            omap[6][1] = new Coin(10);
        omap[6][2] = new Coin(10);    omap[6][3] = new Coin(10);
        omap[6][4] = new Pacman(4,6); omap[6][5] = new Coin(10);
        omap[6][6] = new Coin(10);    omap[6][7] = new Strawberry(100);
        omap[6][8] = new Cherry(200); omap[6][9] = new Wall();
        omap[6][10] =new Coin(10);    omap[6][11] = new Wall();


        //eight row {2,1,1,2,1,1,2,2,1,1,1,2}, 7coin
        omap[7][0] = new Wall();         omap[7][1] = new Coin(10);
        omap[7][2] = new Coin(10); omap[7][3] = new Wall();
        omap[7][4] = new Coin(10); omap[7][5] = new Coin(10);
        omap[7][6] = new Wall();         omap[7][7] = new Wall();
        omap[7][8] = new Coin(10); omap[7][9] = new Coin(10);
        omap[7][10] =new Coin(10); omap[7][11] = new Wall();

        //ninth row {2,1,1,2,1,1,1,2,1,2,1,2}, 7coins
        omap[8][0] = new Wall();         omap[8][1] = new Coin(10);
        omap[8][2] = new Coin(10); omap[8][3] = new Wall();
        omap[8][4] = new Coin(10); omap[8][5] = new Coin(10);
        omap[8][6] = new Coin(10); omap[8][7] = new Wall();
        omap[8][8] = new Coin(10); omap[8][9] = new Wall();
        omap[8][10] =new Coin(10); omap[8][11] = new Wall();

        //tenth row
        omap[9][0] = new Wall();  omap[9][1] = new Wall();
        omap[9][2] = new Wall(); omap[9][3] = new Wall();
        omap[9][4] = new Wall(); omap[9][5] = new Wall();
        omap[9][6] = new Wall(); omap[9][7] = new Wall();
        omap[9][8] = new Wall(); omap[9][9] = new Wall();
        omap[9][10] =new Wall(); omap[9][11] = new Wall();
        //total score 820
    }

    @BeforeEach
    public void setUp() {
        foolghost = new FoolGhost(3,7,5);
        iniMap(omap);
    }
    @Test
    public void testMoveDelay(){
        assertEquals(3,foolghost.getMoveDelay(),"Fool Ghost move delay incorrect");
    }

    @Test
    public void testCollidePacman(){
        Pacman pac = new Pacman(3,7);
        foolghost.collide(pac);
        assertFalse(pac.isPacManAlive(),"Ghost didnt eat Pacman");
    }

    @Test
    public void testDirection(){
        assertEquals(68,foolghost.getDirection(),"Direction incorrect");
    }

    @Test
    public void testMove(){
        int x = foolghost.getX();
        int y = foolghost.getY();
        int[] coor = {x,y};
        foolghost.move(omap,coor);
        assertEquals(y,coor[1],"Fool Ghost move Y wrong");
        assertEquals(x+1,coor[0],"Fool Ghost move X wrong");
    }
}
