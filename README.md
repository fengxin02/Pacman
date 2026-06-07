# Pac-Man

A fully functional Pac-Man game with a graphical user interface, developed in Java as part of the BME "Programming 3" course.

<img width="486" height="493" alt="image" src="https://github.com/user-attachments/assets/fb323d1b-0068-4270-bfb4-63cca23eb5f4" />

## About the Game

Pac-Man is a classic arcade game originally developed in Japan in 1980. You control a character called Pac-Man navigating through a maze. The goal is to eat all coins and fruits in the maze without being caught by the three ghosts that roam around. Each ghost has a different movement pattern. You have only one life -- avoid them at all costs.

## Features

- **Graphical User Interface** built with Java Swing
- **Object-oriented design** with separate classes for game elements, characters, and controls
- **Three ghost types**, each with unique movement patterns (FastGhost, FoolGhost, TeleportGhost)
- **Collision detection** via a polymorphic `collide()` method on all game elements
- **Save and Load** -- save your progress to a JSON file and resume later
- **Keyboard controls** for movement and in-game actions

## How to Run

### Prerequisites

- Java JDK 21 or later
- IntelliJ IDEA (recommended)

### Opening the Project

1. Clone this repository
```bash
  git clone https://github.com/fengxin02/Pacman.git
```
2. Open IntelliJ IDEA, select **File > Open** and choose the project directory
3. Wait for IDEA to index and configure the project
4. Navigate to `src/Project/Main/Main.java`
5. Click the green run button next to the `main` method, or right-click and select **Run 'Main.main()'**

The project includes the Gson library (`lib/gson-2.11.0.jar`) required for JSON save/load functionality. No additional dependency setup is needed.

## Controls

| Key | Action |
|-----|--------|
| W | Move up |
| A | Move left |
| S | Move down |
| D | Move right |
| G | Save current game |

Note: pressing a direction key changes Pac-Man's heading. Pac-Man will keep moving in that direction until hitting a wall. You cannot change direction into a wall.

## Menu

- **Start** -- begin a new game
- **Load Game** -- resume a previously saved game from `saved_map.json`
- **Exit** -- quit the game

## Save System

The game state is serialized to JSON using Google Gson. The save file includes:

- The maze layout (2D grid)
- Current score
- Positions of Pac-Man and all ghosts

Press **G** during gameplay to save. Use the **Load Game** button on the main menu to resume.

## Project Structure

```
src/
  Project/
    Character/     -- Game elements (Pac-Man, ghosts, coins, fruits, walls)
    Frame/         -- Application window and menu frame
    Layout/        -- UI layout managers
    Listener/      -- Keyboard input handling
    Main/          -- Entry point and image loading
    Panel/         -- Game rendering panel
    SaveGame/      -- JSON serialization and save/load logic
    res/           -- Image assets (sprites)
  com/google/gson/typeadapters/
    RuntimeTypeAdapterFactory.java  -- Polymorphic JSON adapter for Gson
lib/
  gson-2.11.0.jar  -- Gson library for JSON processing
```

## Implementation Details

The maze is implemented as a 2D array storing `GameElement` objects. Each element (Coin, Wall, Ghost, Cherry, Strawberry, Pac-Man) implements the `GameElement` interface, which defines a `collide()` method for collision detection. When Pac-Man or a ghost attempts to move into the next cell, the `collide()` method on that element determines the outcome.

Ghost movement is managed by independent logic -- each ghost type overrides the base `Ghost` class to implement its own pathfinding behavior.

The rendering loop updates the game panel at a fixed interval, redrawing all elements based on their current positions in the 2D grid array.
