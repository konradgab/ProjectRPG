package Game;

import Achievement.*;
import Board.Board;
import Config.Config;
import Enemy.Boss;
import Enemy.Monster;
import Fight.FightManager;
import Player.*;
import Player.Builder.*;
import Board.*;
import Utils.IOUtils;
import lombok.Getter;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Config config;
    private static Game game;
    private IBoard board;

    public static Config getConfig() {
        return config;
    }

    public static Game getGame() {
        return game;
    }

    public IBoard getBoard() {
        return board;
    }

    private Game() {
        this.board = new Board();
    }



    public static void main(String[] args) {
        loadConfig();
        game = new Game();
        game.getBoard().gameLoop();


    }

    private static void loadConfig() {
        File config = IOUtils.openFile("config/config.yml", "config.yml");
        try {
            Game.config = IOUtils.getMapper().readValue(config, Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
