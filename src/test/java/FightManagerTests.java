import Enemy.EnemiesGroup;
import Fight.FightManager;
import Utils.IOUtils;

import static org.junit.Assert.assertNotNull;
import static  Utils.TestFunctions.createTestMage;
import static  Utils.TestFunctions.loadMonster;
import static  Utils.TestFunctions.loadAssassin;

public class FightManagerTests {
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
