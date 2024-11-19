package Project.SaveGame;

import Project.Character.GameElement;

/**
 * For saving the game
 */
public class GameState {
    /**
     * Score
     */
    private int score;
    /**
     * Location of the Pacman
     */
    private int[] pacmanLoc;
    /**
     * Location of the Fool Ghost
     */
    private int[] foolghostLoc;
    /**
     * Location of the Teleport Ghost
     */
    private int[] teleghostLoc;
    /**
     * Location of the Fast Ghost
     */
    private int[] fastghostLoc;

    /**
     * Game map
     */
    private GameElement[][] gameMap;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int[] getPacmanLoc() {
        return pacmanLoc;
    }

    public void setPacmanLoc(int[] pacmanLoc) {
        this.pacmanLoc = pacmanLoc;
    }

    public int[] getFoolghostLoc() {
        return foolghostLoc;
    }

    public void setFoolghostLoc(int[] foolghostLoc) {
        this.foolghostLoc = foolghostLoc;
    }

    public int[] getTeleghostLoc() {
        return teleghostLoc;
    }

    public void setTeleghostLoc(int[] teleghostLoc) {
        this.teleghostLoc = teleghostLoc;
    }

    public int[] getFastghostLoc() {
        return fastghostLoc;
    }

    public void setFastghostLoc(int[] fastghostLoc) {
        this.fastghostLoc = fastghostLoc;
    }

    public GameElement[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameElement[][] gameMap) {
        this.gameMap = gameMap;
    }

}
