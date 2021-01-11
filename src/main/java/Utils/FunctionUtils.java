package Utils;

import Enemy.Assassin;

import java.io.File;
import java.io.IOException;

public class FunctionUtils {

    public static boolean checkRange(int lowerBound, int toCheck, int upperBound) {
        return toCheck < upperBound && toCheck >= lowerBound;
    }

    public static Assassin loadDefaultAssassin() {
        File file = IOUtils.openFile("data/assassin.yml", "assassin.yml");
        try {
            return IOUtils.getMapper().readValue(file, Assassin.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
