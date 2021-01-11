package Board;

import Achievement.Achievement;
import Field.Field;
import Field.IField;
import Player.Builder.Director;
import Player.Builder.MageBuilder;
import Player.*;
import Game.*;
import Utils.FunctionUtils;
import Utils.IOUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Getter
public class Board implements IBoard {
    @JsonProperty
    private final String name;
    @JsonProperty
    public final List<IField> Fields = new ArrayList<>();
    @JsonProperty
    private final Player player;

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
            if (gameFields.size() < size - 1) {
                Logger.Logger.printError("Expected " + (size - 1) + " fields but defined in " + levelFileName + " only " + gameFields.size() + ".");
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
        Achievement.getInstance().message("Player created hero: " + name, mage.getName());
        return mage;
    }

    public List<IField> getFields() {
        return Fields;
    }

    @Override
    public void gameLoop() {
        while (true) {
            int choice = nextAction();
            switch (choice) {
                case 1:
                    this.player.getCurrentField().displayActions(this.getPlayer());
                    break;
                case 2:
                    int direction = player.move();
                    travel(direction);
                    player.getEventManager().notify("travel", this.getPlayer());
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public void createAssassin() {
        var assassin = 

    }

    public int nextAction() {
        System.out.println("You are in: " + player.getCurrentField().getName());
        System.out.println("Description: " + player.getCurrentField().getDescription());
        System.out.println("Possible actions: ");
        System.out.println("1. Search for missions.");
        System.out.println("2. Move to the next city.");
        System.out.println("0. Exit");
        System.out.print("What is your next move?(default: 2) ");
        int choice = IOUtils.nextInt();
        if (!FunctionUtils.checkRange(0, choice, 2)) {
            return 2;
        }
        return choice;
    }

    public void travel(int direction) {
        int i = 0;
        for (var field : getFields()) {
            if (field.equals(player.getCurrentField())) break;
            else i++;
        }
        if (direction == 1) {
            player.setCurrentField(this.getFields().get((i + 1) % this.Fields.size()));
        } else {
            if (i - 1 % 10 >= 0) player.setCurrentField(this.getFields().get((i - 1) % this.Fields.size()));
            else player.setCurrentField(this.getFields().get(this.Fields.size() - 1));
        }

    }

    @Override
    public IField getField(int level, int filedNumber) {
        return null;
    }

}
