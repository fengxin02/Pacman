package Project.Panel;

import Project.Character.*;
import Project.Listener.GameKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends JPanel {

    //score
    private int points = 0;
    //pacman
    //private Pacman pacman = new Pacman(4,6);
    private Timer gameTimer;

    //calculate the fps for the movement speed
    private int FpsCounter = 0;
    private int[] pacmanLoc = new int[2];
    private int[] foolghostLoc = new int[2];
    private int[] telepghostLoc = new int[2];
    private GameKeyListener keylis;

    //random map not done yet
    // y[10] x[12]
    private GameElement[][] omap = new GameElement[10][12];

    //root
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
        omap[2][8] = new Coin(10); omap[2][9] = new Coin(10);
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
        omap[5][6] = new Coin(10); omap[5][7] = new FoolGhost(3, 7, 5);
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


    public GamePanel(JFrame menu)
    {
        //add new panel to menu
        menu.add(this);
        menu.setContentPane(this);
        //root
        this.setFocusable(true);
        //root
        iniMap(omap);
        pacmanLoc[0] = 4;
        pacmanLoc[1] = 6;
        foolghostLoc[0] = 7;
        foolghostLoc[1] = 5;
        telepghostLoc[0] = 9;
        telepghostLoc[1] = 1;
        keylis = new GameKeyListener(this, omap, menu);
        this.addKeyListener(keylis);
        //make sure panel focused
        //root
        this.requestFocusInWindow();

        this.setBackground(Color.black);
        //load image




    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        int pacX = pacmanLoc[0];
        int pacY = pacmanLoc[1];
        //hang
        int rows = omap.length;
        //lie
        int cols = omap[0].length;
        int cellheight = height / rows;
        int cellwidth = width / cols;
        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                int x = col * cellwidth;
                int y = row * cellheight;
                omap[row][col].paintImage(g, x, y, cellwidth, cellheight);
//
            }
        }
    }

    public void setDirection(int direc)
    {
        int x = pacmanLoc[0];
        int y = pacmanLoc[1];
        if(x == -1 && y == -1){
            return;
        }
        int pacdirec = omap[y][x].getDirection();
        //68   = d  right
        //65   = a  left
        //87   = w  up
        //83   = s  down
        if(pacdirec == direc)
        {
            return;
        }
        //right
        if(direc == 68)
        {
            boolean move = omap[y][x+1].checkDirec((Pacman)omap[y][x]);
            //check if right block is wall or not
            if(move){
                omap[y][x].setDirection(direc);

            }

        }
        //left
        if(direc == 65)
        {
            boolean move = omap[y][x-1].checkDirec((Pacman)omap[y][x]);
            //check if right block is wall or not
            if(move){
                omap[y][x].setDirection(direc);

            }
        }
        //up
        if(direc == 87)
        {
            boolean move = omap[y-1][x].checkDirec((Pacman)omap[y][x]);
            //check if right block is wall or not
            if(move){
                omap[y][x].setDirection(direc);

            }
        }
        //down
        if(direc == 83)
        {
            boolean move = omap[y+1][x].checkDirec((Pacman)omap[y][x]);
            //check if right block is wall or not
            if(move){
                omap[y][x].setDirection(direc);

            }
        }
    }


    //the game runs here
    public void startGame()
    {

        gameTimer = new Timer(400, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //when map is saved the first elem will be null
                if(omap[0][0] == null)
                {
                    gameTimer.stop();
                }
                //check if game ends, if there is no more coin, you win
                int x = pacmanLoc[0];
                int y = pacmanLoc[1];
                if(omap[y][x].getPoint() == 810)
                {
                    System.out.println("You WIN!");
                    gameTimer.stop();
                    return;
                }
                //root
                revalidate();
                repaint();

                //makes pacman moves slower
                if (FpsCounter % omap[y][x].getMoveDelay() == 0) {
                    omap[y][x].move(omap, pacmanLoc);
                    x = pacmanLoc[0];
                    y = pacmanLoc[1];
                    if (x == -1 && y == -1)
                    {
                        gameTimer.stop();
                        System.out.println("GG");
                        return;
                    }

                    if(omap[y][x].getPoint() > points){

                        points = omap[y][x].getPoint();
                    }
                    //printMap(map);
                    System.out.println();
                    System.out.println(omap[y][x].getDirection());
                    System.out.println();
                }
                //fool ghost move turn
                int fx = foolghostLoc[0];
                int fy = foolghostLoc[1];
                if(FpsCounter % omap[fy][fx].getMoveDelay() == 0)
                {
                    omap[fy][fx].move(omap, foolghostLoc);
                }
                int tx = telepghostLoc[0];
                int ty = telepghostLoc[1];
                if(FpsCounter % omap[ty][tx].getMoveDelay() == 0)
                {
                    omap[ty][tx].move(omap, telepghostLoc);
                }
                //check is pacman alive
                x = pacmanLoc[0];
                y = pacmanLoc[1];
                if (pacmanLoc[0] == foolghostLoc[0] && pacmanLoc[1] == foolghostLoc[1] || pacmanLoc[0] == telepghostLoc[0] && pacmanLoc[1] == telepghostLoc[1])
                {
                    gameTimer.stop();
                    System.out.println("GG");
                    return;
                }
                System.out.println("YOUR POINTS :" + points);

                FpsCounter++;


            }
        });
        gameTimer.start();
    }

}
