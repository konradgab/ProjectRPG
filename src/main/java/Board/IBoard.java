package Board;


import Field.IField;

import java.util.List;

public interface IBoard {

    void gameLoop();

    IField getField(int level, int filedNumber);

    public List<IField> getFields();
}
