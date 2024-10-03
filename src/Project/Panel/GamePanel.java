package Project.Panel;

import Project.Character.FoolGhost;
import Project.Character.Ghost;
import Project.Character.Pacman;
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
    private Pacman pacman = new Pacman();
    private Timer gameTimer;

    //calculate the fps for the movement speed
    private int FpsCounter = 0;

    //loading images
    private BufferedImage PacmanRightImage;
    private BufferedImage PacmanLeftImage;
    private BufferedImage PacmanUpImage;
    private BufferedImage PacmanDownImage;

    private BufferedImage CherryImage;
    private BufferedImage StrawberryImage;
    private BufferedImage CoinImage;
    private BufferedImage GhostImage;
    private BufferedImage WallImage;
    //0 == empty road
    //1 == coins on road
    //2 == wall
    //5 == pacman
    //4  == cherry
    //7 == strawberry
    //20  == fool_ghost, 21 == fool ghost on coin, 27 fool ghost on strawberry, 24 == fool ghost on cherry
    private Ghost foolghost = new FoolGhost(20, 3);
    // need more ghost
    // 40 == smart__ghost
    // 50 == random__ghost

    //random map not done yet
    // [10][12]
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
    public GamePanel(JFrame menu)
    {
        //add new panel to menu
        menu.add(this);
        menu.setContentPane(this);
        //root
        this.setFocusable(true);
        //root
        this.addKeyListener(new GameKeyListener(this));
        //make sure panel focused
        //root
        this.requestFocusInWindow();

        this.setBackground(Color.black);
        //load image

        try {
            CoinImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\coin.png"));
            WallImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\bricks-wall.png"));
            GhostImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\ghost.png"));
            StrawberryImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\strawberry.png"));
            CherryImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\cherries.png"));
            PacmanLeftImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacmanleft.png"));
            PacmanUpImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacmanup.png"));
            PacmanRightImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacman.png"));
            PacmanDownImage = ImageIO.read(new File("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\src\\Project\\res\\pacmandown.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if(PacmanRightImage == null)
        {
            System.out.println("no picture");
        }



    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        //hang
        int rows = map.length;
        //lie
        int cols = map[0].length;
        int cellheight = height / rows;
        int cellwidth = width / cols;
        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                int x = col * cellwidth;
                int y = row * cellheight;

                switch(map[row][col])
                {
                    case 0:

                        break;
                    case 1:
                        g.drawImage(CoinImage, x, y, cellwidth, cellheight, null);
                        break;
                    case 2:
                        g.drawImage(WallImage, x, y, cellwidth, cellheight, null);
                        break;
                    case 4:
                        g.drawImage(CherryImage, x, y, cellwidth, cellheight, null);
                        break;
                    case 5:
                        //check the direction of pacman and choose the right one
                        if(pacman.getDirection() == 65)
                        {
                            g.drawImage(PacmanLeftImage, x, y, cellwidth, cellheight, null);
                        }
                        if(pacman.getDirection() == 87)
                        {
                            g.drawImage(PacmanUpImage, x, y, cellwidth, cellheight, null);
                        }
                        if(pacman.getDirection() == 83)
                        {
                            g.drawImage(PacmanDownImage, x, y, cellwidth, cellheight, null);
                        }
                        if(pacman.getDirection() == 68)
                        {
                            g.drawImage(PacmanRightImage, x, y, cellwidth, cellheight, null);
                        }
                        break;
                    case 7:
                        g.drawImage(StrawberryImage, x, y, cellwidth, cellheight, null);
                        break;
                    //25 26 32 29
                    case 20:
                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
                        break;
                    //9  == fool_ghost, 10 == fool ghost on coin, 16 fool ghost on strawberry, 13 == fool ghost on cherry
                    case 21:
                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
                        break;
                    case 27:
                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
                        break;
                    case 24:
                        g.drawImage(GhostImage, x, y, cellwidth, cellheight, null);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void setDirection(int direc)
    {
        pacman.getPlace(map);
        int x = pacman.getX();
        int y = pacman.getY();
        int pacdirec = pacman.getDirection();
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
            //check if right block is wall or not
            if(map[y][x+1] != 2)
            {
                pacman.setDirection(direc);
            }
        }
        //left
        if(direc == 65)
        {
            if(map[y][x-1] != 2)
            {
                pacman.setDirection(direc);
            }
        }
        //up
        if(direc == 87)
        {
            if(map[y-1][x] != 2)
            {
                pacman.setDirection(direc);
            }
        }
        //down
        if(direc == 83)
        {
            if(map[y+1][x] != 2)
            {
                pacman.setDirection(direc);
            }
        }
    }



    public void move()
    {
        try
        {
            pacman.getPlace(map);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        int x = pacman.getX();
        int y = pacman.getY();
        int direction = pacman.getDirection();
        //68   = d  right
        //65   = a  left
        //87   = w  up
        //83   = s  down
        if(direction == 68) //right
        {
            //if wall
            if(map[y][x+1] == 2)
            {
                //stay and do not do anything
            }
            else
            {
                //you move to next block whatever there is.
                map[y][x] -= 5;
                map[y][x+1] += 5;
                //check add points
                if(map[y][x+1] == 6)
                {
                    //add point
                    points += 1;
                    map[y][x+1] -= 1;
                }
                //check road
                if(map[y][x+1] == 5)
                {
                    map[y][x+1] = 5;
                    //nothing
                }
                //check cherry
                if(map[y][x+1] == 9)
                {
                    map[y][x+1] -= 4;
                    points += 10;
                }
                //check strawberry
                if(map[y][x+1] == 12)
                {
                    map[y][x+1] -= 7;
                    points += 20;
                }

                //20  == fool_ghost, 21 == fool ghost on coin, 27 fool ghost on strawberry, 24 == fool ghost on cherry


                //check run into ghost
                if(map[y][x+1] == 25)
                {
                    //die
                    map[y][x+1] -=5;
                }
                //check run into ghost on coin
                if(map[y][x+1] == 26)
                {
                    //die
                    map[y][x+1] -=5;
                }
                //check run into ghost on strawberry
                if(map[y][x+1] == 32)
                {
                    //die
                    map[y][x+1] -=5;
                }

                //check run into ghost on cherry
                if(map[y][x+1] == 29)
                {
                    //die
                    map[y][x+1] -=5;
                }
            }
        }

        if(direction == 65) //left
        {
            //if wall
            if(map[y][x-1] == 2)
            {
                //stay and do not do anything
            }
            else
            {
                map[y][x] -= 5;
                map[y][x-1] += 5;
                //check add points
                if(map[y][x-1] == 6)
                {
                    //add point
                    points += 1;
                    map[y][x-1] -= 1;
                }
                //check road
                if(map[y][x-1] == 5)
                {
                    //nothing
                }
                //check cherry
                if(map[y][x-1] == 9)
                {
                    map[y][x-1] -= 4;
                    points += 10;
                }
                //check strawberry
                if(map[y][x-1] == 12)
                {
                    map[y][x-1] -= 7;
                    points += 20;
                }
                //25 26 32 29
                //check run into ghost
                if(map[y][x-1] == 25)
                {
                    //die
                    map[y][x-1] -=5;
                }

                //check run into ghost on coin
                if(map[y][x-1] == 26)
                {
                    //die
                    map[y][x-1] -=5;
                }
                //check run into ghost on strawberry
                if(map[y][x-1] == 32)
                {
                    //die
                    map[y][x-1] -=5;
                }

                //check run into ghost on cherry
                if(map[y][x-1] == 29)
                {
                    //die
                    map[y][x-1] -=5;
                }

            }
        }

        if(direction == 87) //up
        {
            //if wall
            if(map[y-1][x] == 2)
            {
                //stay and do not do anything
            }
            else
            {
                map[y][x] =  map[y][x] - 5;
                map[y-1][x] = map[y-1][x] +5;
                //check add points
                if(map[y-1][x] == 6)
                {
                    //add point
                    points += 1;
                    map[y-1][x] -= 1;
                }
                //check road
                if(map[y-1][x] == 5)
                {
                    map[y-1][x] = 5;
                    //nothing
                }
                //check cherry
                if(map[y-1][x] == 9)
                {
                    map[y-1][x] -= 4;
                    points += 10;
                }
                //check strawberry
                if(map[y-1][x] == 12)
                {
                    map[y-1][x] -= 7;
                    points += 20;
                }
                //25 26 32 29

                //check run into ghost
                if(map[y-1][x] == 25)
                {
                    //die
                    map[y-1][x] -=5;
                }

                //check run into ghost on coin
                if(map[y-1][x] == 26)
                {
                    //die
                    map[y-1][x] -=5;
                }
                //check run into ghost on strawberry
                if(map[y-1][x] == 32)
                {
                    //die
                    map[y-1][x] -=5;
                }

                //check run into ghost on cherry
                if(map[y-1][x] == 29)
                {
                    //die
                    map[y-1][x] -=5;
                }

            }
        }

        if(direction == 83) //down
        {
            //if wall
            if(map[y+1][x] == 2)
            {
                //stay and do not do anything
            }
            else
            {
                map[y][x] = map[y][x] - 5;
                map[y+1][x] = map[y+1][x] + 5;
                //check add points
                if(map[y+1][x] == 6)
                {
                    //add point
                    points += 1;
                    map[y+1][x] -= 1;
                }
                //check road
                if(map[y+1][x] == 5)
                {
                    map[y+1][x] = 5;
                    //nothing
                }
                //check cherry
                if(map[y+1][x] == 9)
                {
                    map[y+1][x] -= 4;
                    points += 10;
                }
                //check strawberry
                if(map[y+1][x] == 12)
                {
                    map[y+1][x] -= 7;
                    points += 20;
                }


                //25 26 32 29

                //check run into ghost
                if(map[y+1][x] == 25)
                {
                    //die
                    map[y+1][x] -=5;
                }
                //check run into ghost on coin
                if(map[y+1][x] == 26)
                {
                    //die
                    map[y+1][x] -=5;
                }
                //check run into ghost on strawberry
                if(map[y+1][x] == 32)
                {
                    //die
                    map[y+1][x] -=5;
                }

                //check run into ghost on cherry
                if(map[y+1][x] == 29)
                {
                    //die
                    map[y+1][x] -=5;
                }

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
                //root
                revalidate();
                repaint();
                //makes pacman moves slower
                if (FpsCounter % pacman.getPacManMoveDelay() == 0) {
                    move();
                    printMap(map);
                    System.out.println();
                    System.out.println(pacman.getDirection());
                    System.out.println();
                }
                if(FpsCounter % foolghost.getGhostMoveDelay() == 0)
                {
                    foolghost.move(map);
                    //
                }
                System.out.println("YOUR POINTS :" + points);

                FpsCounter++;

                pacman.getPlace(map);
                int x = pacman.getX();
                int y = pacman.getY();
                if (x == -1 && y == -1)
                {
                    gameTimer.stop();
                    System.out.println("GG");
                }
                //check if game ends, if there is no more coin, you win
                int coinCount = 0;
                for(int rows = 0; rows < map.length; rows++)
                {
                    for(int cols = 0; cols < map[0].length; cols++)
                    {
                        //check if there is any gold more, and any ghost step on gold
                        if(map[rows][cols] == 1 || map[rows][cols] == foolghost.getGhostId()+1)
                        {
                            coinCount++;
                        }
                    }
                }
                if(coinCount == 0)
                {
                    gameTimer.stop();
                    System.out.println("You WIN!");
                }
            }
        });
        gameTimer.start();
    }

//    public void startGame()
//    {
//        int i = 0;
//        while(true)
//        {
//            if(i % 1050 == 0)
//            {
//                move();
//                printMap(map);
//                System.out.println();
//                System.out.println();
//            }
//            i++;
//            pacman.getPlace(map);
//            int x = pacman.getX();
//            int y = pacman.getY();
//            if(x == -1 && y == -1)
//            {
//                break;
//            }
//        }
//    }



}
