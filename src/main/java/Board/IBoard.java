package Board;


import Field.IField;

import java.util.List;

public interface IBoard {
    void startGame();

    void gameLoop();

    IField getField(int level, int filedNumber);

    void save();

    void gameFinish();

    public List<IField> getFields();
}
