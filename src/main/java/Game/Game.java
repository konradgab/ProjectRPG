package Game;

import Achievement.*;
import Board.Board;
import Config.Config;
import Enemy.Monster;
import Fight.FightManager;
import Player.*;
import Player.Builder.*;
import Board.*;
import lombok.Getter;


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



    public static void main(String[] args) {
        startGame();

    }


    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj jak sie nazywasz?");
        String name = scanner.nextLine();
        MageBuilder mb = new MageBuilder();
        Director director = new Director(mb);
        director.constructEasyMage();
        PlayerMage mage = mb.getProduct();
        mage.setName(name);
        mage.displayStatistics();
        mage.printAbilities();
        Achievement.getInstance().message("Player created hero: " + name);
        //Monster yeti = new Monster("Yeti", 100, 0 , 0 );
        //FightManager.fightPlayerVsEnemy(mage,yeti);
    }


}
