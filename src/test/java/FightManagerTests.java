import Enemy.Assassin;
import Enemy.EnemiesGroup;
import Enemy.Monster;
import Fight.FightManager;
import Utils.IOUtils;

import static org.junit.Assert.assertNotNull;

import Player.Builder.Director;
import Player.Builder.MageBuilder;
import Player.Builder.ScoutBuilder;
import Player.Builder.WarriorBuilder;
import Player.PlayerMage;
import Player.PlayerScout;
import Player.PlayerWarrior;

import java.io.File;
import java.io.IOException;


public class FightManagerTests {
    public PlayerMage createTestMage() {
        var mb = new MageBuilder();
        var director = new Director(mb);
        director.constructTestMage();
        return mb.getProduct();
    }

    public PlayerWarrior createTestWarrior() {
        var wb = new WarriorBuilder();
        var director = new Director(wb);
        director.constructEasyWarrior();
        return wb.getProduct();
    }

    public PlayerScout createTestScout() {
        var sb = new ScoutBuilder();
        var director = new Director(sb);
        director.constructEasyScout();
        return sb.getProduct();
    }

    private Monster loadMonster() {
        //File config = IOUtils.openFile("config/config.yml", "config.yml");
        File file = IOUtils.openFile("src/test/resources/monsterTest.yml", "monsterTest.yml");
        try {
            return IOUtils.getMapper().readValue(file, Monster.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Assassin loadAssassin() {
        File file = IOUtils.openFile("src/test/resources/assassinTest.yml", "assassinTest.yml");
        try {
            return IOUtils.getMapper().readValue(file, Assassin.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void FightAgainstMonsterTest() {
        var testPlayer = createTestMage();
        testPlayer.setName("test");
        var testMonster = loadMonster();
        assertNotNull(testMonster);
        assertNotNull(testPlayer);
        FightManager.startFight(testPlayer, testMonster);
    }

    public void FightAgainstGroupMonstersTest() {
        var testPlayer = createTestMage();
        testPlayer.setName("test");
        var testMonster1 = loadMonster();
        var testMonster2 = loadMonster();
        var testMonster3 = loadMonster();
        var testMonster4 = loadMonster();
        var testMonster5 = loadMonster();
        EnemiesGroup testEnemiesGroup = new EnemiesGroup("TestGroup");
        testEnemiesGroup.add(testMonster1);
        testEnemiesGroup.add(testMonster2);
        testEnemiesGroup.add(testMonster3);
        testEnemiesGroup.add(testMonster4);
        testEnemiesGroup.add(testMonster5);
        assertNotNull(testPlayer);
        FightManager.startFight(testPlayer, testEnemiesGroup);
    }

    public void FightAgainstAssassinTest() {
        var testPlayer = createTestMage();
        testPlayer.setName("test");
        var testAssassin = loadAssassin();
        assert testAssassin != null;
        System.out.println(testAssassin.getCurrentHealth());
        FightManager.startFight(testPlayer, testAssassin);
    }


    public static void main(String[] args) {
        var test = new FightManagerTests();
        System.out.println("Available tests: ");
        System.out.println("1. Fight against group of monsters.");
        System.out.println("2. Fight against assassin.");
        System.out.println("3. Fight against monster.");
        var choice = IOUtils.getScanner().nextInt();
        if (choice < 1 || choice > 3) System.out.println("This test does not exist.");
        else {
            switch (choice) {
                case 1:
                    test.FightAgainstGroupMonstersTest();
                case 2:
                    test.FightAgainstAssassinTest();
                case 3:
                    test.FightAgainstMonsterTest();
            }
        }
    }

}
