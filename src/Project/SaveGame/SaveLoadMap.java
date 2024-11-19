package Project.SaveGame;

import Project.Character.*;
import Project.Frame.MenuFrame;
import Project.Layout.MenuLayout;
import Project.Panel.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import static Project.Main.Main.showMenu;


//saves the game to JSON
public class SaveLoadMap {
    private MenuFrame menu;

    /**
     * Load the game from json
     * @param filePath where the saved game is
     * @return Saved game stats
     */
    public static GameState loadGame(String filePath) {
        RuntimeTypeAdapterFactory<GameElement> gameElementAdapterFactory = RuntimeTypeAdapterFactory
                .of(GameElement.class, "type")
                .registerSubtype(Wall.class, "Wall")
                .registerSubtype(FoolGhost.class, "FoolGhost")
                .registerSubtype(FastGhost.class, "FastGhost")
                .registerSubtype(TeleportGhost.class, "TeleportGhost")
                .registerSubtype(Cherry.class, "Cherry")
                .registerSubtype(Coin.class, "Coin")
                .registerSubtype(Pacman.class, "Pacman")
                .registerSubtype(Strawberry.class, "Strawberry")
                .registerSubtype(Road.class, "Road");



        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(gameElementAdapterFactory)  // 注册自定义的 TypeAdapterFactory
                .setPrettyPrinting()
                .create();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, GameState.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Save the current game
     * @param gameState current game stats
     * @param filePath where to save the game
     */
    public static void saveGame(GameState gameState, String filePath){

        RuntimeTypeAdapterFactory<GameElement> gameElementAdapterFactory = RuntimeTypeAdapterFactory
                .of(GameElement.class, "type")
                .registerSubtype(Wall.class, "Wall")
                .registerSubtype(FoolGhost.class, "FoolGhost")
                .registerSubtype(FastGhost.class, "FastGhost")
                .registerSubtype(TeleportGhost.class, "TeleportGhost")
                .registerSubtype(Cherry.class, "Cherry")
                .registerSubtype(Coin.class, "Coin")
                .registerSubtype(Pacman.class, "Pacman")
                .registerSubtype(Strawberry.class, "Strawberry")
                .registerSubtype(Road.class, "Road");

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(gameElementAdapterFactory)  // 注册自定义的 TypeAdapterFactory
                .setPrettyPrinting()
                .create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(gameState, writer);
            System.out.println("Game saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

