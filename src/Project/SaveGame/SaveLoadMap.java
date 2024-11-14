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
//    public SaveMap(GameState gs, GameElement[][] map, MenuFrame menuFrame) {
//        menu = menuFrame;
//        // save somehow
//
//        //end the game with first elem be null
//        map[0][0] = null;
//        showMenu(menu);
//
//    }

    public static GameState loadGame(String filePath) {
        RuntimeTypeAdapterFactory<GameElement> gameElementAdapterFactory = RuntimeTypeAdapterFactory
                .of(GameElement.class, "type")  // "type" 字段用来保存类型信息
                .registerSubtype(Wall.class, "Wall")
                .registerSubtype(FoolGhost.class, "FoolGhost")
                .registerSubtype(FastGhost.class, "FastGhost")
                .registerSubtype(TeleportGhost.class, "TeleportGhost")
                .registerSubtype(Cherry.class, "Cherry")
                .registerSubtype(Coin.class, "Coin")
                .registerSubtype(Pacman.class, "Pacman")
                .registerSubtype(Strawberry.class, "Strawberry")
                .registerSubtype(Road.class, "Road");




        //Gson gson = new Gson();
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
    public static void saveGame(GameState gameState, String filePath){

        // 创建 RuntimeTypeAdapterFactory，用于保存和加载 GameElement 及其子类
        RuntimeTypeAdapterFactory<GameElement> gameElementAdapterFactory = RuntimeTypeAdapterFactory
                .of(GameElement.class, "type")  // "type" 字段用来保存类型信息
                .registerSubtype(Wall.class, "Wall")
                .registerSubtype(FoolGhost.class, "FoolGhost")
                .registerSubtype(FastGhost.class, "FastGhost")
                .registerSubtype(TeleportGhost.class, "TeleportGhost")
                .registerSubtype(Cherry.class, "Cherry")
                .registerSubtype(Coin.class, "Coin")
                .registerSubtype(Pacman.class, "Pacman")
                .registerSubtype(Strawberry.class, "Strawberry")
                .registerSubtype(Road.class, "Road");



//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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

