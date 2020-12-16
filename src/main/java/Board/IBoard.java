package Board;


import Field.IField;

public interface IBoard {
    void startGame();

    void gameLoop();

    IField getField(int level, int filedNumber);

    void save();

    void gameFinish();
}
