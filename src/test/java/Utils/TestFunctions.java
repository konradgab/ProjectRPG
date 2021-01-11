package Utils;

import Enemy.Assassin;
import Enemy.Monster;
import Player.Builder.Director;
import Player.Builder.MageBuilder;
import Player.Builder.ScoutBuilder;
import Player.Builder.WarriorBuilder;
import Player.PlayerMage;
import Player.PlayerScout;
import Player.PlayerWarrior;

import java.io.File;
import java.io.IOException;

public class TestFunctions {
    public static PlayerMage createTestMage() {
        var mb = new MageBuilder();
        var director = new Director(mb);
        director.constructTestMage();
        return mb.getProduct();
    }

    public static PlayerWarrior createTestWarrior() {
        var wb = new WarriorBuilder();
        var director = new Director(wb);
        director.constructEasyWarrior();
        return wb.getProduct();
    }

    public static PlayerScout createTestScout() {
        var sb = new ScoutBuilder();
        var director = new Director(sb);
        director.constructEasyScout();
        return sb.getProduct();
    }

    public static Monster loadMonster() {
        File file = IOUtils.openFile("src/test/resources/monsterTest.yml", "monsterTest.yml");
        try {
            return IOUtils.getMapper().readValue(file, Monster.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Assassin loadAssassin() {
        File file = IOUtils.openFile("src/test/resources/assassinTest.yml", "assassinTest.yml");
        try {
            return IOUtils.getMapper().readValue(file, Assassin.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
