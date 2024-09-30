package Project.Panel;

import Project.Character.Pacman;
import Project.Listener.GameKeyListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Arrays;


public class GamePanel extends JPanel {
    private JPanel root;
    private int points = 0;
    private Pacman pacman = new Pacman();
    private Timer gameTimer;

    //0 == empty road
    //1 == spots on road
    //2 == wall
    //5 == pacman
    //4  == cherry
    //7 == strawberry
    //9  == ghost

    //random map not done yet
    private int[][] map = {
            {2,2,2,2,2,2,2,2,2,2,2,2},
            {2,1,1,1,1,1,1,1,1,1,1,2},
            {2,1,2,2,1,1,1,1,1,1,1,2},
            {2,1,1,1,2,2,2,2,2,2,2,2},
            {2,1,2,2,2,2,1,2,1,1,1,2},
            {2,1,1,2,1,1,9,1,1,1,1,2},
            {2,1,1,2,5,1,1,4,7,2,1,2},
            {2,1,1,2,1,1,2,2,1,1,1,2},
            {2,1,1,2,1,1,1,2,1,2,1,2},
            {2,2,2,2,2,2,2,2,2,2,2,2},
    };

    public GamePanel(JPanel root)
    {
        this.root = root;
        this.root.setFocusable(true);
        this.root.addKeyListener(new GameKeyListener(this));
        //make sure panel focused
        this.root.requestFocusInWindow();



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

                //check run into ghost
                if(map[y][x+1] == 14)
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

                //check run into ghost
                if(map[y][x-1] == 14)
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
                map[y-1][x] = map[y][x] +5;
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

                //check run into ghost
                if(map[y-1][x] == 14)
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
                map[y+1][x] = map[y][x] + 5;
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

                //check run into ghost
                if(map[y+1][x] == 14)
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


    public void startGame()
    {
        gameTimer = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                printMap(map);
                System.out.println();
                System.out.println(pacman.getDirection());
                System.out.println();
                pacman.getPlace(map);
                int x = pacman.getX();
                int y = pacman.getY();
                if (x == -1 && y == -1)
                {
                    gameTimer.stop();
                    System.out.println("GG");
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
