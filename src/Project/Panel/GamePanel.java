package Project.Panel;

import Project.Character.*;
import Project.Frame.MenuFrame;
import Project.Layout.GameOverLayout;
import Project.Listener.GameKeyListener;
import Project.SaveGame.GameState;
import Project.SaveGame.SaveLoadMap;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Project.Main.Main.showMenu;


public class GamePanel extends JPanel {

    /**
     * Score
     */
    private int points = 0;
    /**
     * Game timer thread where game runs
     */
    private Timer gameTimer;
    /**
     * For calculation characters movement speed
     */
    private int FpsCounter = 0;
    /**
     * Location of the Pacman
     */
    private int[] pacmanLoc = new int[2];
    /**
     * Location of the Fool Ghost
     */
    private int[] foolghostLoc = new int[2];
    /**
     * Location of the Teleport Ghost
     */
    private int[] telepghostLoc = new int[2];
    /**
     * Location of the Fast Ghost
     */
    private int[] fastghostLoc = new int[2];
    /**
     * Key Listener
     */
    private GameKeyListener keylis;
    /**
     * Main frame
     */
    private MenuFrame menu;
    // y[10] x[12]
    /**
     * Game map
     */
    private GameElement[][] omap = new GameElement[10][12];
    //private GameElement[][] omap = new GameElement[21][33];

    public void iniMap1(GameElement[][] omap){
        omap[0][0] = new Wall();
        omap[0][1] = new Wall();
        omap[0][2] = new Wall();
        omap[0][3] = new Wall();
        omap[0][4] = new Wall();
        omap[0][5] = new Wall();
        omap[0][6] = new Wall();
        omap[0][7] = new Wall();
        omap[0][8] = new Wall();
        omap[0][9] = new Wall();
        omap[0][10] = new Wall();
        omap[0][11] = new Wall();
        omap[0][12] = new Wall();
        omap[0][13] = new Wall();
        omap[0][14] = new Wall();
        omap[0][15] = new Wall();
        omap[0][16] = new Wall();
        omap[0][17] = new Wall();
        omap[0][18] = new Wall();
        omap[0][19] = new Wall();
        omap[0][20] = new Wall();
        omap[0][21] = new Wall();
        omap[0][22] = new Wall();
        omap[0][23] = new Wall();
        omap[0][24] = new Wall();
        omap[0][25] = new Wall();
        omap[0][26] = new Wall();
        omap[0][27] = new Wall();
        omap[0][28] = new Wall();
        omap[0][29] = new Wall();
        omap[0][30] = new Wall();
        omap[0][31] = new Wall();
        omap[0][32] = new Wall();
        omap[1][0] = new Wall();
        omap[1][1] = new Coin(10);
        omap[1][2] = new Coin(10);
        omap[1][3] = new Coin(10);
        omap[1][4] = new Cherry(200);
        omap[1][5] = new Coin(10);
        omap[1][6] = new Coin(10);
        omap[1][7] = new Coin(10);
        omap[1][8] = new Coin(10);
        omap[1][9] = new Coin(10);
        omap[1][10] = new Coin(10);
        omap[1][11] = new Coin(10);
        omap[1][12] = new Coin(10);
        omap[1][13] = new Coin(10);
        omap[1][14] = new Coin(10);
        omap[1][15] = new Coin(10);
        omap[1][16] = new Wall();
        omap[1][17] = new Coin(10);
        omap[1][18] = new Coin(10);
        omap[1][19] = new Coin(10);
        omap[1][20] = new Coin(10);
        omap[1][21] = new Coin(10);
        omap[1][22] = new Coin(10);
        omap[1][23] = new Coin(10);
        omap[1][24] = new Coin(10);
        omap[1][25] = new Coin(10);
        omap[1][26] = new Coin(10);
        omap[1][27] = new Coin(10);
        omap[1][28] = new Cherry(200);
        omap[1][29] = new Coin(10);
        omap[1][30] = new Coin(10);
        omap[1][31] = new Coin(10);
        omap[1][32] = new Wall();
        omap[2][0] = new Wall();
        omap[2][1] = new Coin(10);
        omap[2][2] = new Wall();
        omap[2][3] = new Wall();
        omap[2][4] = new Wall();
        omap[2][5] = new Wall();
        omap[2][6] = new Wall();
        omap[2][7] = new Wall();
        omap[2][8] = new Coin(10);
        omap[2][9] = new Wall();
        omap[2][10] = new Wall();
        omap[2][11] = new Wall();
        omap[2][12] = new Wall();
        omap[2][13] = new Wall();
        omap[2][14] = new Wall();
        omap[2][15] = new Coin(10);
        omap[2][16] = new Wall();
        omap[2][17] = new Coin(10);
        omap[2][18] = new Wall();
        omap[2][19] = new Wall();
        omap[2][20] = new Wall();
        omap[2][21] = new Wall();
        omap[2][22] = new Wall();
        omap[2][23] = new Wall();
        omap[2][24] = new Coin(10);
        omap[2][25] = new Wall();
        omap[2][26] = new Wall();
        omap[2][27] = new Wall();
        omap[2][28] = new Wall();
        omap[2][29] = new Wall();
        omap[2][30] = new Wall();
        omap[2][31] = new Coin(10);
        omap[2][32] = new Wall();
        omap[3][0] = new Wall();
        omap[3][1] = new Coin(10);
        omap[3][2] = new Coin(10);
        omap[3][3] = new Coin(10);
        omap[3][4] = new Coin(10);
        omap[3][5] = new Coin(10);
        omap[3][6] = new Coin(10);
        omap[3][7] = new Coin(10);
        omap[3][8] = new Cherry(200);
        omap[3][9] = new Coin(10);
        omap[3][10] = new Coin(10);
        omap[3][11] = new Coin(10);
        omap[3][12] = new Coin(10);
        omap[3][13] = new Coin(10);
        omap[3][14] = new Coin(10);
        omap[3][15] = new Coin(10);
        omap[3][16] = new Coin(10);
        omap[3][17] = new Coin(10);
        omap[3][18] = new Coin(10);
        omap[3][19] = new Coin(10);
        omap[3][20] = new Coin(10);
        omap[3][21] = new Coin(10);
        omap[3][22] = new Coin(10);
        omap[3][23] = new Coin(10);
        omap[3][24] = new Cherry(200);
        omap[3][25] = new Coin(10);
        omap[3][26] = new Coin(10);
        omap[3][27] = new Coin(10);
        omap[3][28] = new Coin(10);
        omap[3][29] = new Coin(10);
        omap[3][30] = new Coin(10);
        omap[3][31] = new Coin(10);
        omap[3][32] = new Wall();
        omap[4][0] = new Wall();
        omap[4][1] = new Coin(10);
        omap[4][2] = new Wall();
        omap[4][3] = new Wall();
        omap[4][4] = new Wall();
        omap[4][5] = new Wall();
        omap[4][6] = new Wall();
        omap[4][7] = new Wall();
        omap[4][8] = new Coin(10);
        omap[4][9] = new Wall();
        omap[4][10] = new Coin(10);
        omap[4][11] = new Wall();
        omap[4][12] = new Wall();
        omap[4][13] = new Wall();
        omap[4][14] = new Wall();
        omap[4][15] = new Wall();
        omap[4][16] = new Wall();
        omap[4][17] = new Wall();
        omap[4][18] = new Wall();
        omap[4][19] = new Wall();
        omap[4][20] = new Wall();
        omap[4][21] = new Wall();
        omap[4][22] = new Coin(10);
        omap[4][23] = new Wall();
        omap[4][24] = new Coin(10);
        omap[4][25] = new Wall();
        omap[4][26] = new Wall();
        omap[4][27] = new Wall();
        omap[4][28] = new Wall();
        omap[4][29] = new Wall();
        omap[4][30] = new Wall();
        omap[4][31] = new Coin(10);
        omap[4][32] = new Wall();
        omap[5][0] = new Wall();
        omap[5][1] = new Coin(10);
        omap[5][2] = new Coin(10);
        omap[5][3] = new Coin(10);
        omap[5][4] = new Cherry(200);
        omap[5][5] = new Coin(10);
        omap[5][6] = new Coin(10);
        omap[5][7] = new Coin(10);
        omap[5][8] = new Coin(10);
        omap[5][9] = new Wall();
        omap[5][10] = new Coin(10);
        omap[5][11] = new Coin(10);
        omap[5][12] = new Coin(10);
        omap[5][13] = new Coin(10);
        omap[5][14] = new Coin(10);
        omap[5][15] = new Coin(10);
        omap[5][16] = new Wall();
        omap[5][17] = new Coin(10);
        omap[5][18] = new Coin(10);
        omap[5][19] = new Coin(10);
        omap[5][20] = new Coin(10);
        omap[5][21] = new Coin(10);
        omap[5][22] = new Coin(10);
        omap[5][23] = new Wall();
        omap[5][24] = new Coin(10);
        omap[5][25] = new Coin(10);
        omap[5][26] = new Coin(10);
        omap[5][27] = new Coin(10);
        omap[5][28] = new Cherry(200);
        omap[5][29] = new Coin(10);
        omap[5][30] = new Coin(10);
        omap[5][31] = new Coin(10);
        omap[5][32] = new Wall();
        omap[6][0] = new Wall();
        omap[6][1] = new Wall();
        omap[6][2] = new Wall();
        omap[6][3] = new Wall();
        omap[6][4] = new Wall();
        omap[6][5] = new Wall();
        omap[6][6] = new Wall();
        omap[6][7] = new Wall();
        omap[6][8] = new Coin(10);
        omap[6][9] = new Wall();
        omap[6][10] = new Wall();
        omap[6][11] = new Wall();
        omap[6][12] = new Wall();
        omap[6][13] = new Wall();
        omap[6][14] = new Wall();
        omap[6][15] = new Coin(10);
        omap[6][16] = new Wall();
        omap[6][17] = new Coin(10);
        omap[6][18] = new Wall();
        omap[6][19] = new Wall();
        omap[6][20] = new Wall();
        omap[6][21] = new Wall();
        omap[6][22] = new Wall();
        omap[6][23] = new Wall();
        omap[6][24] = new Coin(10);
        omap[6][25] = new Wall();
        omap[6][26] = new Wall();
        omap[6][27] = new Wall();
        omap[6][28] = new Wall();
        omap[6][29] = new Wall();
        omap[6][30] = new Wall();
        omap[6][31] = new Wall();
        omap[6][32] = new Wall();
        omap[7][0] = new Wall();
        omap[7][1] = new Coin(10);
        omap[7][2] = new Coin(10);
        omap[7][3] = new Coin(10);
        omap[7][4] = new Coin(10);
        omap[7][5] = new Coin(10);
        omap[7][6] = new Coin(10);
        omap[7][7] = new Coin(10);
        omap[7][8] = new Coin(10);
        omap[7][9] = new Wall();
        omap[7][10] = new Coin(10);
        omap[7][11] = new Coin(10);
        omap[7][12] = new Cherry(200);
        omap[7][13] = new Coin(10);
        omap[7][14] = new Coin(10);
        omap[7][15] = new Coin(10);
        omap[7][16] = new Coin(10);
        omap[7][17] = new Coin(10);
        omap[7][18] = new Coin(10);
        omap[7][19] = new Coin(10);
        omap[7][20] = new Cherry(200);
        omap[7][21] = new Coin(10);
        omap[7][22] = new Coin(10);
        omap[7][23] = new Wall();
        omap[7][24] = new Coin(10);
        omap[7][25] = new Coin(10);
        omap[7][26] = new Coin(10);
        omap[7][27] = new Coin(10);
        omap[7][28] = new Coin(10);
        omap[7][29] = new Coin(10);
        omap[7][30] = new Coin(10);
        omap[7][31] = new Coin(10);
        omap[7][32] = new Wall();
        omap[8][0] = new Wall();
        omap[8][1] = new Wall();
        omap[8][2] = new Wall();
        omap[8][3] = new Wall();
        omap[8][4] = new Wall();
        omap[8][5] = new Wall();
        omap[8][6] = new Wall();
        omap[8][7] = new Wall();
        omap[8][8] = new Coin(10);
        omap[8][9] = new Wall();
        omap[8][10] = new Coin(10);
        omap[8][11] = new Wall();
        omap[8][12] = new Wall();
        omap[8][13] = new Wall();
        omap[8][14] = new Coin(10);
        omap[8][15] = new Coin(10);
        omap[8][16] = new Coin(10);
        omap[8][17] = new Coin(10);
        omap[8][18] = new Coin(10);
        omap[8][19] = new Wall();
        omap[8][20] = new Wall();
        omap[8][21] = new Wall();
        omap[8][22] = new Coin(10);
        omap[8][23] = new Wall();
        omap[8][24] = new Coin(10);
        omap[8][25] = new Wall();
        omap[8][26] = new Wall();
        omap[8][27] = new Wall();
        omap[8][28] = new Wall();
        omap[8][29] = new Wall();
        omap[8][30] = new Wall();
        omap[8][31] = new Wall();
        omap[8][32] = new Wall();
        omap[9][0] = new Wall();
        omap[9][1] = new Coin(10);
        omap[9][2] = new Coin(10);
        omap[9][3] = new Coin(10);
        omap[9][4] = new Coin(10);
        omap[9][5] = new Coin(10);
        omap[9][6] = new Coin(10);
        omap[9][7] = new Coin(10);
        omap[9][8] = new Coin(10);
        omap[9][9] = new Coin(10);
        omap[9][10] = new Coin(10);
        omap[9][11] = new Wall();
        omap[9][12] = new Coin(10);
        omap[9][13] = new Coin(10);
        omap[9][14] = new Coin(10);
        omap[9][15] = new Coin(10);
        omap[9][16] = new Coin(10);
        omap[9][17] = new Coin(10);
        omap[9][18] = new Coin(10);
        omap[9][19] = new Coin(10);
        omap[9][20] = new Coin(10);
        omap[9][21] = new Wall();
        omap[9][22] = new Coin(10);
        omap[9][23] = new Coin(10);
        omap[9][24] = new Coin(10);
        omap[9][25] = new Coin(10);
        omap[9][26] = new Coin(10);
        omap[9][27] = new Coin(10);
        omap[9][28] = new Coin(10);
        omap[9][29] = new Coin(10);
        omap[9][30] = new Coin(10);
        omap[9][31] = new Coin(10);
        omap[9][32] = new Wall();
        omap[10][0] = new Wall();
        omap[10][1] = new Wall();
        omap[10][2] = new Wall();
        omap[10][3] = new Wall();
        omap[10][4] = new Wall();
        omap[10][5] = new Wall();
        omap[10][6] = new Wall();
        omap[10][7] = new Wall();
        omap[10][8] = new Coin(10);
        omap[10][9] = new Wall();
        omap[10][10] = new Coin(10);
        omap[10][11] = new Wall();
        omap[10][12] = new Coin(10);
        omap[10][13] = new Coin(10);
        omap[10][14] = new Coin(10);
        omap[10][15] = new Coin(10);
        omap[10][16] = new Coin(10);
        omap[10][17] = new Coin(10);
        omap[10][18] = new Coin(10);
        omap[10][19] = new Coin(10);
        omap[10][20] = new Coin(10);
        omap[10][21] = new Wall();
        omap[10][22] = new Coin(10);
        omap[10][23] = new Wall();
        omap[10][24] = new Coin(10);
        omap[10][25] = new Wall();
        omap[10][26] = new Wall();
        omap[10][27] = new Wall();
        omap[10][28] = new Wall();
        omap[10][29] = new Wall();
        omap[10][30] = new Wall();
        omap[10][31] = new Wall();
        omap[10][32] = new Wall();
        omap[11][0] = new Wall();
        omap[11][1] = new Coin(10);
        omap[11][2] = new Coin(10);
        omap[11][3] = new Coin(10);
        omap[11][4] = new Coin(10);
        omap[11][5] = new Coin(10);
        omap[11][6] = new Coin(10);
        omap[11][7] = new Coin(10);
        omap[11][8] = new Coin(10);
        omap[11][9] = new Coin(10);
        omap[11][10] = new Coin(10);
        omap[11][11] = new Wall();
        omap[11][12] = new Coin(10);
        omap[11][13] = new FastGhost(1,13,11);
        omap[11][14] = new Coin(10);
        omap[11][15] = new Coin(10);
        omap[11][16] = new Coin(10);
        omap[11][17] = new FoolGhost(3, 17, 11);
        omap[11][18] = new Coin(10);
        omap[11][19] = new TeleportGhost(10,19,11);
        omap[11][20] = new Coin(10);
        omap[11][21] = new Wall();
        omap[11][22] = new Coin(10);
        omap[11][23] = new Coin(10);
        omap[11][24] = new Coin(10);
        omap[11][25] = new Coin(10);
        omap[11][26] = new Coin(10);
        omap[11][27] = new Coin(10);
        omap[11][28] = new Coin(10);
        omap[11][29] = new Coin(10);
        omap[11][30] = new Coin(10);
        omap[11][31] = new Coin(10);
        omap[11][32] = new Wall();
        omap[12][0] = new Wall();
        omap[12][1] = new Wall();
        omap[12][2] = new Wall();
        omap[12][3] = new Wall();
        omap[12][4] = new Wall();
        omap[12][5] = new Wall();
        omap[12][6] = new Wall();
        omap[12][7] = new Wall();
        omap[12][8] = new Coin(10);
        omap[12][9] = new Wall();
        omap[12][10] = new Coin(10);
        omap[12][11] = new Wall();
        omap[12][12] = new Wall();
        omap[12][13] = new Wall();
        omap[12][14] = new Wall();
        omap[12][15] = new Wall();
        omap[12][16] = new Wall();
        omap[12][17] = new Wall();
        omap[12][18] = new Wall();
        omap[12][19] = new Wall();
        omap[12][20] = new Wall();
        omap[12][21] = new Wall();
        omap[12][22] = new Coin(10);
        omap[12][23] = new Wall();
        omap[12][24] = new Coin(10);
        omap[12][25] = new Wall();
        omap[12][26] = new Wall();
        omap[12][27] = new Wall();
        omap[12][28] = new Wall();
        omap[12][29] = new Wall();
        omap[12][30] = new Wall();
        omap[12][31] = new Wall();
        omap[12][32] = new Wall();
        omap[13][0] = new Wall();
        omap[13][1] = new Coin(10);
        omap[13][2] = new Coin(10);
        omap[13][3] = new Coin(10);
        omap[13][4] = new Coin(10);
        omap[13][5] = new Coin(10);
        omap[13][6] = new Coin(10);
        omap[13][7] = new Coin(10);
        omap[13][8] = new Coin(10);
        omap[13][9] = new Wall();
        omap[13][10] = new Coin(10);
        omap[13][11] = new Coin(10);
        omap[13][12] = new Cherry(200);
        omap[13][13] = new Coin(10);
        omap[13][14] = new Coin(10);
        omap[13][15] = new Coin(10);
        omap[13][16] = new Coin(10);
        omap[13][17] = new Coin(10);
        omap[13][18] = new Coin(10);
        omap[13][19] = new Coin(10);
        omap[13][20] = new Cherry(200);
        omap[13][21] = new Coin(10);
        omap[13][22] = new Coin(10);
        omap[13][23] = new Wall();
        omap[13][24] = new Coin(10);
        omap[13][25] = new Coin(10);
        omap[13][26] = new Coin(10);
        omap[13][27] = new Coin(10);
        omap[13][28] = new Coin(10);
        omap[13][29] = new Coin(10);
        omap[13][30] = new Coin(10);
        omap[13][31] = new Coin(10);
        omap[13][32] = new Wall();
        omap[14][0] = new Wall();
        omap[14][1] = new Wall();
        omap[14][2] = new Wall();
        omap[14][3] = new Wall();
        omap[14][4] = new Wall();
        omap[14][5] = new Wall();
        omap[14][6] = new Wall();
        omap[14][7] = new Wall();
        omap[14][8] = new Coin(10);
        omap[14][9] = new Wall();
        omap[14][10] = new Wall();
        omap[14][11] = new Wall();
        omap[14][12] = new Wall();
        omap[14][13] = new Wall();
        omap[14][14] = new Wall();
        omap[14][15] = new Coin(10);
        omap[14][16] = new Wall();
        omap[14][17] = new Coin(10);
        omap[14][18] = new Wall();
        omap[14][19] = new Wall();
        omap[14][20] = new Wall();
        omap[14][21] = new Wall();
        omap[14][22] = new Wall();
        omap[14][23] = new Wall();
        omap[14][24] = new Coin(10);
        omap[14][25] = new Wall();
        omap[14][26] = new Wall();
        omap[14][27] = new Wall();
        omap[14][28] = new Wall();
        omap[14][29] = new Wall();
        omap[14][30] = new Wall();
        omap[14][31] = new Wall();
        omap[14][32] = new Wall();
        omap[15][0] = new Wall();
        omap[15][1] = new Coin(10);
        omap[15][2] = new Coin(10);
        omap[15][3] = new Coin(10);
        omap[15][4] = new Cherry(200);
        omap[15][5] = new Coin(10);
        omap[15][6] = new Coin(10);
        omap[15][7] = new Coin(10);
        omap[15][8] = new Coin(10);
        omap[15][9] = new Wall();
        omap[15][10] = new Coin(10);
        omap[15][11] = new Coin(10);
        omap[15][12] = new Coin(10);
        omap[15][13] = new Coin(10);
        omap[15][14] = new Pacman(14,15);
        omap[15][15] = new Coin(10);
        omap[15][16] = new Wall();
        omap[15][17] = new Coin(10);
        omap[15][18] = new Coin(10);
        omap[15][19] = new Coin(10);
        omap[15][20] = new Coin(10);
        omap[15][21] = new Coin(10);
        omap[15][22] = new Coin(10);
        omap[15][23] = new Wall();
        omap[15][24] = new Coin(10);
        omap[15][25] = new Coin(10);
        omap[15][26] = new Coin(10);
        omap[15][27] = new Coin(10);
        omap[15][28] = new Cherry(200);
        omap[15][29] = new Coin(10);
        omap[15][30] = new Coin(10);
        omap[15][31] = new Coin(10);
        omap[15][32] = new Wall();
        omap[16][0] = new Wall();
        omap[16][1] = new Coin(10);
        omap[16][2] = new Wall();
        omap[16][3] = new Wall();
        omap[16][4] = new Wall();
        omap[16][5] = new Wall();
        omap[16][6] = new Wall();
        omap[16][7] = new Wall();
        omap[16][8] = new Coin(10);
        omap[16][9] = new Wall();
        omap[16][10] = new Coin(10);
        omap[16][11] = new Wall();
        omap[16][12] = new Wall();
        omap[16][13] = new Wall();
        omap[16][14] = new Wall();
        omap[16][15] = new Wall();
        omap[16][16] = new Wall();
        omap[16][17] = new Wall();
        omap[16][18] = new Wall();
        omap[16][19] = new Wall();
        omap[16][20] = new Wall();
        omap[16][21] = new Wall();
        omap[16][22] = new Coin(10);
        omap[16][23] = new Wall();
        omap[16][24] = new Coin(10);
        omap[16][25] = new Wall();
        omap[16][26] = new Wall();
        omap[16][27] = new Wall();
        omap[16][28] = new Wall();
        omap[16][29] = new Wall();
        omap[16][30] = new Wall();
        omap[16][31] = new Coin(10);
        omap[16][32] = new Wall();
        omap[17][0] = new Wall();
        omap[17][1] = new Coin(10);
        omap[17][2] = new Coin(10);
        omap[17][3] = new Coin(10);
        omap[17][4] = new Coin(10);
        omap[17][5] = new Coin(10);
        omap[17][6] = new Coin(10);
        omap[17][7] = new Coin(10);
        omap[17][8] = new Cherry(200);
        omap[17][9] = new Coin(10);
        omap[17][10] = new Coin(10);
        omap[17][11] = new Coin(10);
        omap[17][12] = new Coin(10);
        omap[17][13] = new Coin(10);
        omap[17][14] = new Coin(10);
        omap[17][15] = new Coin(10);
        omap[17][16] = new Coin(10);
        omap[17][17] = new Coin(10);
        omap[17][18] = new Coin(10);
        omap[17][19] = new Coin(10);
        omap[17][20] = new Coin(10);
        omap[17][21] = new Coin(10);
        omap[17][22] = new Coin(10);
        omap[17][23] = new Coin(10);
        omap[17][24] = new Cherry(200);
        omap[17][25] = new Coin(10);
        omap[17][26] = new Coin(10);
        omap[17][27] = new Coin(10);
        omap[17][28] = new Coin(10);
        omap[17][29] = new Coin(10);
        omap[17][30] = new Coin(10);
        omap[17][31] = new Coin(10);
        omap[17][32] = new Wall();
        omap[18][0] = new Wall();
        omap[18][1] = new Coin(10);
        omap[18][2] = new Wall();
        omap[18][3] = new Wall();
        omap[18][4] = new Wall();
        omap[18][5] = new Wall();
        omap[18][6] = new Wall();
        omap[18][7] = new Wall();
        omap[18][8] = new Coin(10);
        omap[18][9] = new Wall();
        omap[18][10] = new Wall();
        omap[18][11] = new Wall();
        omap[18][12] = new Wall();
        omap[18][13] = new Wall();
        omap[18][14] = new Wall();
        omap[18][15] = new Coin(10);
        omap[18][16] = new Wall();
        omap[18][17] = new Coin(10);
        omap[18][18] = new Wall();
        omap[18][19] = new Wall();
        omap[18][20] = new Wall();
        omap[18][21] = new Wall();
        omap[18][22] = new Wall();
        omap[18][23] = new Wall();
        omap[18][24] = new Coin(10);
        omap[18][25] = new Wall();
        omap[18][26] = new Wall();
        omap[18][27] = new Wall();
        omap[18][28] = new Wall();
        omap[18][29] = new Wall();
        omap[18][30] = new Wall();
        omap[18][31] = new Coin(10);
        omap[18][32] = new Wall();
        omap[19][0] = new Wall();
        omap[19][1] = new Coin(10);
        omap[19][2] = new Coin(10);
        omap[19][3] = new Coin(10);
        omap[19][4] = new Cherry(200);
        omap[19][5] = new Coin(10);
        omap[19][6] = new Coin(10);
        omap[19][7] = new Coin(10);
        omap[19][8] = new Coin(10);
        omap[19][9] = new Coin(10);
        omap[19][10] = new Coin(10);
        omap[19][11] = new Coin(10);
        omap[19][12] = new Coin(10);
        omap[19][13] = new Coin(10);
        omap[19][14] = new Coin(10);
        omap[19][15] = new Coin(10);
        omap[19][16] = new Wall();
        omap[19][17] = new Coin(10);
        omap[19][18] = new Coin(10);
        omap[19][19] = new Coin(10);
        omap[19][20] = new Coin(10);
        omap[19][21] = new Coin(10);
        omap[19][22] = new Coin(10);
        omap[19][23] = new Coin(10);
        omap[19][24] = new Coin(10);
        omap[19][25] = new Coin(10);
        omap[19][26] = new Coin(10);
        omap[19][27] = new Coin(10);
        omap[19][28] = new Cherry(200);
        omap[19][29] = new Coin(10);
        omap[19][30] = new Coin(10);
        omap[19][31] = new Coin(10);
        omap[19][32] = new Wall();
        omap[20][0] = new Wall();
        omap[20][1] = new Wall();
        omap[20][2] = new Wall();
        omap[20][3] = new Wall();
        omap[20][4] = new Wall();
        omap[20][5] = new Wall();
        omap[20][6] = new Wall();
        omap[20][7] = new Wall();
        omap[20][8] = new Wall();
        omap[20][9] = new Wall();
        omap[20][10] = new Wall();
        omap[20][11] = new Wall();
        omap[20][12] = new Wall();
        omap[20][13] = new Wall();
        omap[20][14] = new Wall();
        omap[20][15] = new Wall();
        omap[20][16] = new Wall();
        omap[20][17] = new Wall();
        omap[20][18] = new Wall();
        omap[20][19] = new Wall();
        omap[20][20] = new Wall();
        omap[20][21] = new Wall();
        omap[20][22] = new Wall();
        omap[20][23] = new Wall();
        omap[20][24] = new Wall();
        omap[20][25] = new Wall();
        omap[20][26] = new Wall();
        omap[20][27] = new Wall();
        omap[20][28] = new Wall();
        omap[20][29] = new Wall();
        omap[20][30] = new Wall();
        omap[20][31] = new Wall();
        omap[20][32] = new Wall();


    }


    /**
     * Initialize the game map with Game elements
     * @param omap game map
     */
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
        omap[1][8] = new Strawberry(100); omap[1][9] = new TeleportGhost(10,9,1);
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
        omap[5][6] = new Coin(10); omap[5][7] = new FoolGhost(3, 7, 5);
        omap[5][8] = new Coin(10); omap[5][9] = new Coin(10);
        omap[5][10] =new Coin(10); omap[5][11] = new Wall();


        //seventh row {2,1,1,1,5,1,1,4,7,2,1,2}, 6coin, 1strawberry,1cherry
        omap[6][0] = new Wall();            omap[6][1] = new Coin(10);
        omap[6][2] = new Coin(10);    omap[6][3] = new Coin(10);
        omap[6][4] = new Pacman(4,6); omap[6][5] = new Coin(10);
        omap[6][6] = new Coin(10);    omap[6][7] = new Coin(10);
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

    public GamePanel(MenuFrame menu, GameState gt){
        this.menu = menu;
        //add new panel to menu
        menu.add(this);
        menu.setContentPane(this);
        //root
        this.setFocusable(true);

        omap = gt.getGameMap();
        pacmanLoc = gt.getPacmanLoc();
        foolghostLoc = gt.getFoolghostLoc();
        telepghostLoc = gt.getTeleghostLoc();
        fastghostLoc = gt.getFastghostLoc();
        points = gt.getScore();

        keylis = new GameKeyListener(this, omap, menu);
        this.addKeyListener(keylis);
        //make sure panel focused
        //root
        this.requestFocusInWindow();
        this.setBackground(Color.black);
    }



    public GamePanel(MenuFrame menu)
    {
        this.menu = menu;
        //add new panel to menu
        menu.add(this);
        menu.setContentPane(this);
        //root
        this.setFocusable(true);
        //root
        iniMap(omap);
//        pacmanLoc[0] = 14;
//        pacmanLoc[1] = 15;
//        foolghostLoc[0] = 17;
//        foolghostLoc[1] = 11;
//        telepghostLoc[0] = 19;
//        telepghostLoc[1] = 11;
//        fastghostLoc[0] = 13;
//        fastghostLoc[1] = 11;

        pacmanLoc[0] = 4;
        pacmanLoc[1] = 6;
        foolghostLoc[0] = 7;
        foolghostLoc[1] = 5;
        telepghostLoc[0] = 9;
        telepghostLoc[1] = 1;
        fastghostLoc[0] = 9;
        fastghostLoc[1] = 2;

        keylis = new GameKeyListener(this, omap, menu);
        this.addKeyListener(keylis);
        this.requestFocusInWindow();
        this.setBackground(Color.black);
    }

    /**
     * Save the game to json
     */
    public void saveGameState(){
        GameState gameState = new GameState();
        gameState.setScore(points);
        gameState.setPacmanLoc(pacmanLoc);
        gameState.setFoolghostLoc(foolghostLoc);
        gameState.setTeleghostLoc(telepghostLoc);
        gameState.setFastghostLoc(fastghostLoc);
        gameState.setGameMap(omap);
        SaveLoadMap.saveGame(gameState,"C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\saved_map.json");
        omap[0][0] = null;
        this.removeAll();
        this.revalidate();
        this.repaint();
        menu.remove(this);
        showMenu(menu);
    }

    /**
     * Draw the game
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
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

    /**
     * Check the direction of Pacman
     * @param direc
     */
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

    /**
     * Remove all from this Panel
     */
    private void deletePanel(){
        this.removeAll();
        this.revalidate();
        this.repaint();
        menu.remove(this);
    }

    /**
     * Game end panel
     * @param result score
     * @throws InterruptedException
     */
    private void gameOver(String result) throws InterruptedException {
        Thread.sleep(500);
        deletePanel();
        JPanel root = new JPanel();
        menu.add(root);
        menu.setContentPane(root);
        root.setFocusable(true);
        root.setLayout(new GameOverLayout());
        root.setBackground(new Color(220,69,255));
        menu.setVisible(true);
        JLabel title = new JLabel(result);
        title.setFont(new Font("Copper Black", Font.BOLD, 50));
        title.setForeground(new Color(230,242,86));
        JLabel score = new JLabel("   You score: " + points);
        score.setFont(new Font("Copper Black", Font.BOLD, 30));
        score.setForeground(new Color(255,127,80));

        JButton startButton = new JButton("Back to Menu");
        root.add(title);
        root.add(score);
        root.add(startButton);
        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deletePanel();
                showMenu(menu);
            }
        });


        root.revalidate();
        root.repaint();

    }

    //the game runs here

    /**
     * Where the game runs
     */
    public void startGame()
    {
        gameTimer = new Timer(400, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (pacmanLoc[0] == foolghostLoc[0] && pacmanLoc[1] == foolghostLoc[1] || pacmanLoc[0] == telepghostLoc[0] && pacmanLoc[1] == telepghostLoc[1]|| pacmanLoc[0] == fastghostLoc[0] && pacmanLoc[1] == fastghostLoc[1])
                {
                    gameTimer.stop();
                    System.out.println("GG");
                    try {
                        gameOver("Game Over");
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    return;
                }
                int x = pacmanLoc[0];
                int y = pacmanLoc[1];
                if (x == -1 && y == -1) {
                    repaint();
                    gameTimer.stop();
                    System.out.println("GG");
                    try {
                        gameOver("Game Over");
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    return;
                }


                //when map is saved the first elem will be null
                if(omap[0][0] == null)
                {
                    gameTimer.stop();
                }
                //check if game ends, if there is no more coin, you win
                 x = pacmanLoc[0];
                  y = pacmanLoc[1];
                if(omap[y][x].getPoint() == 800) //6520
                {
                    System.out.println("You WIN!");
                    gameTimer.stop();
                    try {
                        gameOver("  You WIN!");
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
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
                        if (x == -1 && y == -1) {
                        } else {
                            if (omap[y][x].getPoint() > points) {

                                points = omap[y][x].getPoint();
                            }
                        }
                        //printMap(map);
                    }

                x = pacmanLoc[0];
                y = pacmanLoc[1];
                //if pacman is dead ghost will not  move and wait till next repaint
                if(!(x == -1 && y == -1)) {
                    //fool ghost move turn
                    int fx = foolghostLoc[0];
                    int fy = foolghostLoc[1];
                    if (FpsCounter % omap[fy][fx].getMoveDelay() == 0) {
                        omap[fy][fx].move(omap, foolghostLoc);
                    }
                    //teleport ghost move turn
                    int tx = telepghostLoc[0];
                    int ty = telepghostLoc[1];
                    if (FpsCounter % omap[ty][tx].getMoveDelay() == 0) {
                        omap[ty][tx].move(omap, telepghostLoc);
                    }

                    //fast ghsot move turn
                    int fastx = fastghostLoc[0];
                    int fasty = fastghostLoc[1];
                    if (FpsCounter % omap[fasty][fastx].getMoveDelay() == 0) {
                        omap[fasty][fastx].move(omap, fastghostLoc);
                    }
                }
                System.out.println("YOUR POINTS :" + points);

                FpsCounter++;


            }
        });
        gameTimer.start();
    }

}
