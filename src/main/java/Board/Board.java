package Board;

import Achievement.Achievement;
import Field.Field;
import Field.IField;
import Player.Builder.Director;
import Player.Builder.MageBuilder;
import Player.*;
import Game.*;
import Utils.IOUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class Board implements IBoard {
    @JsonProperty
    private String name;
    @JsonProperty
    public final List<IField> Fields = new ArrayList<>();
    @JsonProperty
    private Player player;

    public Board() {
        loadLevel(Fields, "data/level-1-field-common.yml", "level-1-field-common.yml", Game.getConfig().getBoardSize());
        this.name = Game.getConfig().getLandName();
        this.player = createHero();
        player.setCurrentField(Fields.get(0));
    }

    private void loadLevel(List<IField> levelList, String levelFileName, String resource, int size) {
        File levelFile = IOUtils.openFile(levelFileName, resource);
        try {
            List<Field> gameFields = IOUtils.getMapper().readValue(levelFile, new TypeReference<>() {
            });
            if(gameFields.size() < size - 1){
                Logger.Logger.printError("Expected "+(size-1)+" fields but defined in "+levelFileName+" only "+gameFields.size()+".");
                System.exit(1);
            }

            levelList.addAll(gameFields.subList(0, size));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Player createHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what's your name?");
        String name = scanner.nextLine();
        MageBuilder mb = new MageBuilder();
        Director director = new Director(mb);
        director.constructEasyMage();
        PlayerMage mage = mb.getProduct();
        mage.setName(name);
        Achievement.getInstance().message("Player created hero: " + name);
        return mage;
    }

    @Override
    public void startGame() {

    }

    public List<IField> getFields() {
        return Fields;
    }

    @Override
    public void gameLoop() {
        while (true) {
            System.out.println("You are in: " + player.getCurrentField().getName());
            System.out.println("Description: " + player.getCurrentField().getDescription());
            player.getCurrentField().displayActions();
            System.out.println("Do u want to try complete this mission? [y/n]");
            String choice = IOUtils.getScanner().next();
            if(choice.equals("y")) {
                player.getCurrentField().execute(this.getPlayer());
            } else {
                break;
            }
        }

    }


    @Override
    public IField getField(int level, int filedNumber) {
        return null;
    }

    @Override
    public void save() {

    }

    @Override
    public void gameFinish() {

    }
}
