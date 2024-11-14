package Project.SaveGame;

import Project.Character.GameElement;

public class GameState {

    private int score;
    private int[] pacmanLoc;
    private int[] foolghostLoc;
    private int[] teleghostLoc;
    private int[] fastghostLoc;
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
