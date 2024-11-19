import Project.Character.*;
import Project.SaveGame.GameState;
import Project.SaveGame.SaveLoadMap;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

import static Project.SaveGame.SaveLoadMap.saveGame;
import static org.junit.jupiter.api.Assertions.*;

public class SaveLoadTest {

    private static GameState gameState;
    private static GameElement[][] omap;
    private static int[] pacmanLoc = new int[2];
    private static int[] foolghostLoc = new int[2];
    private static int[] telepghostLoc = new int[2];
    private static int[] fastghostLoc = new int[2];
    private static int score = 10;
    public static void iniMap(GameElement[][] omap){
        //first row
        omap[0][0] = new Wall();
        omap[0][1] = new FoolGhost(2,1,0);

        //second row 10coin
        omap[1][0] = new Pacman(0,1);
        omap[1][1] = new TeleportGhost(5,1,1);

        //third row 8coins
        omap[2][0] = new FastGhost(10,0,2);
        omap[2][1] = new Coin(10);

        omap[3][0] = new Strawberry(10);
        omap[3][1] = new Cherry(100);

        omap[4][0] = new Road();
        omap[4][1] = new Wall();

    }
    @BeforeAll
    public static void  setUp() {
        gameState = new GameState();
        omap = new GameElement[5][2];
        iniMap(omap);
        pacmanLoc[0] = 0;
        pacmanLoc[1] = 1;
        foolghostLoc[0] = 1;
        foolghostLoc[1] = 0;
        telepghostLoc[0] = 1;
        telepghostLoc[1] = 1;
        fastghostLoc[0] = 0;
        fastghostLoc[1] = 2;
        gameState.setScore(score);
        gameState.setPacmanLoc(pacmanLoc);
        gameState.setFoolghostLoc(foolghostLoc);
        gameState.setTeleghostLoc(telepghostLoc);
        gameState.setFastghostLoc(fastghostLoc);
        gameState.setGameMap(omap);
    }
    @Test
    public void testSaveGame() {
        saveGame(gameState,"C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\testsave.json");
    }
    @Test
    public void testLoadGame() {
        GameState load = SaveLoadMap.loadGame("C:\\Users\\fengx\\Desktop\\BMEschool\\prog3\\Nagy_hazi\\Pacman\\testsave.json");
        if(load == null){
            System.out.println("failed");
        }
        assertEquals(load.getScore(),gameState.getScore());
        assertArrayEquals(load.getPacmanLoc(),gameState.getPacmanLoc());
        assertArrayEquals(load.getFoolghostLoc(),gameState.getFoolghostLoc());
        assertArrayEquals(load.getFastghostLoc(),gameState.getFastghostLoc());
        assertArrayEquals(load.getTeleghostLoc(),gameState.getTeleghostLoc());
        GameElement[][] actualMap = load.getGameMap();

        assertInstanceOf(Wall.class, actualMap[0][0]);
        assertInstanceOf(FoolGhost.class, actualMap[0][1]);

        assertInstanceOf(Pacman.class, actualMap[1][0]);
        assertInstanceOf(TeleportGhost.class, actualMap[1][1]);

        assertInstanceOf(FastGhost.class, actualMap[2][0]);
        assertInstanceOf(Coin.class, actualMap[2][1]);

        assertInstanceOf(Strawberry.class, actualMap[3][0]);
        assertInstanceOf(Cherry.class, actualMap[3][1]);

        assertInstanceOf(Road.class, actualMap[4][0]);
        assertInstanceOf(Wall.class, actualMap[4][1]);
    }

}
