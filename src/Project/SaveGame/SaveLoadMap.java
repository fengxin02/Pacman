package Project.SaveGame;

import Project.Character.GameElement;
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
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, GameState.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void saveGame(GameState gameState, String filePath){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(gameState, writer);
            System.out.println("Game saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

