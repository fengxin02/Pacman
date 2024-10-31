package Project.Panel;

import Project.Character.*;
import Project.Listener.GameKeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel {

    //score
    private int points = 0;
    //pacman
    //private Pacman pacman = new Pacman(4,6);
    private Timer gameTimer;

    //calculate the fps for the movement speed
    private int FpsCounter = 0;
    private int[] pacmanMove = new int[2];

    //loading images

    //0 == empty road
    //1 == coins on road
    //2 == wall
    //5 == pacman
    //4  == cherry
    //7 == strawberry
    //20  == fool_ghost, 21 == fool ghost on coin, 27 fool ghost on strawberry, 24 == fool ghost on cherry
    private Ghost foolghost = new FoolGhost( 3);
    // considering putting all 3 ghosts into an ArrayList to make the task correct
    // need more ghost
    // 40 == smart__ghost
    // 50 == random__ghost

    //random map not done yet
    // [10][12]
    private GameElement[][] omap = new GameElement[10][12];

    private int[][] map = {
            {2,2,2,2,2,2,2,2,2,2,2,2},
            {2,1,1,1,1,1,1,1,1,1,1,2},
            {2,1,2,2,1,1,1,1,1,1,1,2},
            {2,1,1,1,2,2,2,2,2,2,2,2},
            {2,1,2,2,2,2,2,2,1,1,1,2},
            {2,1,1,2,1,1,20,1,1,1,1,2},
            {2,1,1,1,5,1,1,4,7,2,1,2},
            {2,1,1,2,1,1,2,2,1,1,1,2},
            {2,1,1,2,1,1,1,2,1,2,1,2},
            {2,2,2,2,2,2,2,2,2,2,2,2},
    };
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
        omap[1][8] = new Coin(10); omap[1][9] = new Coin(10);
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
        omap[5][6] = new Coin(10); omap[5][7] = new FoolGhost(3);
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
        this.addKeyListener(new GameKeyListener(this, map, menu));
        //make sure panel focused
        //root
        this.requestFocusInWindow();

        this.setBackground(Color.black);
        //load image


        iniMap(omap);
        pacmanMove[0] = 4;
        pacmanMove[1] = 6;

    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        int pacX = pacmanMove[0];
        int pacY = pacmanMove[1];
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
//                switch(omap[row][col])
//                {
//                    case 0:
//                        break;
//                    case 1:
//                        g.drawImage(CoinImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    case 2:
//                        g.drawImage(WallImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    case 4:
//                        g.drawImage(CherryImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    case 5:
//                        //check the direction of pacman and choose the right one
//                        if(omap[pacY][pacX].getDirection() == 65)
//                        {
//                            g.drawImage(PacmanLeftImage, x, y, cellwidth, cellheight, null);
//                        }
//                        if(omap[pacY][pacX].getDirection() == 87)
//                        {
//                            g.drawImage(PacmanUpImage, x, y, cellwidth, cellheight, null);
//                        }
//                        if(omap[pacY][pacX].getDirection() == 83)
//                        {
//                            g.drawImage(PacmanDownImage, x, y, cellwidth, cellheight, null);
//                        }
//                        if(omap[pacY][pacX].getDirection() == 68)
//                        {
//                            g.drawImage(PacmanRightImage, x, y, cellwidth, cellheight, null);
//                        }
//                        break;
//                    case 7:
//                        g.drawImage(StrawberryImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    //25 26 32 29
//                    case 20:
//                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    //9  == fool_ghost, 10 == fool ghost on coin, 16 fool ghost on strawberry, 13 == fool ghost on cherry
//                    case 21:
//                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    case 27:
//                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    case 24:
//                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
//                        break;
//                    default:
//                        break;
//                }
            }
        }
    }

    public void setDirection(int direc)
    {
        int x = pacmanMove[0];
        int y = pacmanMove[1];
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




    //if there is no 5 in map game over

    public void printMap(int[][] map)
    {
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[0].length; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }



    //the game runs here
    public void startGame()
    {
        gameTimer = new Timer(400, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //check if game is loaded, if game is loaded then first date changes to 1000
//                if(map[0][0] == 1000)
//                {
//                    gameTimer.stop();
//                }

                //check if game ends, if there is no more coin, you win
                int x = pacmanMove[0];
                int y = pacmanMove[1];
                if(omap[y][x].getPoint() == 820)
                {
                    System.out.println("You WIN!");
                    gameTimer.stop();
                }
                //root
                revalidate();
                repaint();

                //makes pacman moves slower
                if (FpsCounter % omap[y][x].getMoveDelay() == 0) {

                    omap[y][x].move(omap,pacmanMove);
                    if(omap[y][x].getPoint() > points){
                        points = omap[y][x].getPoint();
                    }
                    //printMap(map);
                    System.out.println();
                    System.out.println(omap[y][x].getDirection());
                    System.out.println();
                }
                if(FpsCounter % foolghost.getGhostMoveDelay() == 0)
                {
//                    foolghost.move(map,pacmanMove);
                    //
                }
                System.out.println("YOUR POINTS :" + points);

                FpsCounter++;

                x = pacmanMove[0];
                y = pacmanMove[1];
                if (x == -1 && y == -1)
                {
                    gameTimer.stop();
                    System.out.println("GG");
                }
//                //check if game ends, if there is no more coin, you win
//                int coinCount = 0;
//                for(int rows = 0; rows < map.length; rows++)
//                {
//                    for(int cols = 0; cols < map[0].length; cols++)
//                    {
//                        //check if there is any gold more, and any ghost step on gold
//                        if(map[rows][cols] == 1 || map[rows][cols] == foolghost.getGhostId()+1)
//                        {
//                            coinCount++;
//                        }
//                    }
//                }
//                if(coinCount == 0)
//                {
//                    gameTimer.stop();
//                    System.out.println("You WIN!");
//                }
            }
        });
        gameTimer.start();
    }

}












//    public void move()
//    {
//        try
//        {
//            pacman.getPlace(map);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        int x = pacman.getX();
//        int y = pacman.getY();
//        int direction = pacman.getDirection();
//        //68   = d  right
//        //65   = a  left
//        //87   = w  up
//        //83   = s  down
//        if(direction == 68) //right
//        {
//            //if wall
//            if(map[y][x+1] == 2)
//            {
//                //stay and do not do anything
//            }
//            else
//            {
//                //you move to next block whatever there is.
//                map[y][x] -= 5;
//                map[y][x+1] += 5;
//                //check add points
//                if(map[y][x+1] == 6)
//                {
//                    //add point
//                    points += 1;
//                    map[y][x+1] -= 1;
//                }
//                //check road
//                if(map[y][x+1] == 5)
//                {
//                    map[y][x+1] = 5;
//                    //nothing
//                }
//                //check cherry
//                if(map[y][x+1] == 9)
//                {
//                    map[y][x+1] -= 4;
//                    points += 10;
//                }
//                //check strawberry
//                if(map[y][x+1] == 12)
//                {
//                    map[y][x+1] -= 7;
//                    points += 20;
//                }
//
//                //20  == fool_ghost, 21 == fool ghost on coin, 27 fool ghost on strawberry, 24 == fool ghost on cherry
//
//
//                //check run into ghost
//                if(map[y][x+1] == 25)
//                {
//                    //die
//                    map[y][x+1] -=5;
//                }
//                //check run into ghost on coin
//                if(map[y][x+1] == 26)
//                {
//                    //die
//                    map[y][x+1] -=5;
//                }
//                //check run into ghost on strawberry
//                if(map[y][x+1] == 32)
//                {
//                    //die
//                    map[y][x+1] -=5;
//                }
//
//                //check run into ghost on cherry
//                if(map[y][x+1] == 29)
//                {
//                    //die
//                    map[y][x+1] -=5;
//                }
//            }
//        }
//
//        if(direction == 65) //left
//        {
//            //if wall
//            if(map[y][x-1] == 2)
//            {
//                //stay and do not do anything
//            }
//            else
//            {
//                map[y][x] -= 5;
//                map[y][x-1] += 5;
//                //check add points
//                if(map[y][x-1] == 6)
//                {
//                    //add point
//                    points += 1;
//                    map[y][x-1] -= 1;
//                }
//                //check road
//                if(map[y][x-1] == 5)
//                {
//                    //nothing
//                }
//                //check cherry
//                if(map[y][x-1] == 9)
//                {
//                    map[y][x-1] -= 4;
//                    points += 10;
//                }
//                //check strawberry
//                if(map[y][x-1] == 12)
//                {
//                    map[y][x-1] -= 7;
//                    points += 20;
//                }
//                //25 26 32 29
//                //check run into ghost
//                if(map[y][x-1] == 25)
//                {
//                    //die
//                    map[y][x-1] -=5;
//                }
//
//                //check run into ghost on coin
//                if(map[y][x-1] == 26)
//                {
//                    //die
//                    map[y][x-1] -=5;
//                }
//                //check run into ghost on strawberry
//                if(map[y][x-1] == 32)
//                {
//                    //die
//                    map[y][x-1] -=5;
//                }
//
//                //check run into ghost on cherry
//                if(map[y][x-1] == 29)
//                {
//                    //die
//                    map[y][x-1] -=5;
//                }
//
//            }
//        }
//
//        if(direction == 87) //up
//        {
//            //if wall
//            if(map[y-1][x] == 2)
//            {
//                //stay and do not do anything
//            }
//            else
//            {
//                map[y][x] =  map[y][x] - 5;
//                map[y-1][x] = map[y-1][x] +5;
//                //check add points
//                if(map[y-1][x] == 6)
//                {
//                    //add point
//                    points += 1;
//                    map[y-1][x] -= 1;
//                }
//                //check road
//                if(map[y-1][x] == 5)
//                {
//                    map[y-1][x] = 5;
//                    //nothing
//                }
//                //check cherry
//                if(map[y-1][x] == 9)
//                {
//                    map[y-1][x] -= 4;
//                    points += 10;
//                }
//                //check strawberry
//                if(map[y-1][x] == 12)
//                {
//                    map[y-1][x] -= 7;
//                    points += 20;
//                }
//                //25 26 32 29
//
//                //check run into ghost
//                if(map[y-1][x] == 25)
//                {
//                    //die
//                    map[y-1][x] -=5;
//                }
//
//                //check run into ghost on coin
//                if(map[y-1][x] == 26)
//                {
//                    //die
//                    map[y-1][x] -=5;
//                }
//                //check run into ghost on strawberry
//                if(map[y-1][x] == 32)
//                {
//                    //die
//                    map[y-1][x] -=5;
//                }
//
//                //check run into ghost on cherry
//                if(map[y-1][x] == 29)
//                {
//                    //die
//                    map[y-1][x] -=5;
//                }
//
//            }
//        }
//
//        if(direction == 83) //down
//        {
//            //if wall
//            if(map[y+1][x] == 2)
//            {
//                //stay and do not do anything
//            }
//            else
//            {
//                map[y][x] = map[y][x] - 5;
//                map[y+1][x] = map[y+1][x] + 5;
//                //check add points
//                if(map[y+1][x] == 6)
//                {
//                    //add point
//                    points += 1;
//                    map[y+1][x] -= 1;
//                }
//                //check road
//                if(map[y+1][x] == 5)
//                {
//                    map[y+1][x] = 5;
//                    //nothing
//                }
//                //check cherry
//                if(map[y+1][x] == 9)
//                {
//                    map[y+1][x] -= 4;
//                    points += 10;
//                }
//                //check strawberry
//                if(map[y+1][x] == 12)
//                {
//                    map[y+1][x] -= 7;
//                    points += 20;
//                }
//
//
//                //25 26 32 29
//
//                //check run into ghost
//                if(map[y+1][x] == 25)
//                {
//                    //die
//                    map[y+1][x] -=5;
//                }
//                //check run into ghost on coin
//                if(map[y+1][x] == 26)
//                {
//                    //die
//                    map[y+1][x] -=5;
//                }
//                //check run into ghost on strawberry
//                if(map[y+1][x] == 32)
//                {
//                    //die
//                    map[y+1][x] -=5;
//                }
//
//                //check run into ghost on cherry
//                if(map[y+1][x] == 29)
//                {
//                    //die
//                    map[y+1][x] -=5;
//                }
//
//            }
//        }
//
//    }
