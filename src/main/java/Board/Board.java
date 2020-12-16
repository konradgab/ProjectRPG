package Board;

import Field.Field;
import Field.IField;
import Player.Player;
import Game.*;
import Utils.IOUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board implements IBoard {
    @JsonProperty
    private String name;
    @JsonProperty
    private final List<IField> Fields = new ArrayList<>();
    @JsonProperty
    private Player player;

    public Board() {
        loadLevel(Fields, "data/level-1-field-common.yml", "level-1-field-common.yml", Game.getConfig().getBoardSize());
        this.name = Game.getConfig().getLandName();
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
            levelList.addAll(gameFields.subList(0, size - 1));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void startGame() {

    }

    @Override
    public void gameLoop() {

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
