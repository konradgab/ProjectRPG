package Achievement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Achievement {

    private static Achievement instance;

    private Achievement() {
    }

    ;

    public static synchronized Achievement getInstance() {
        if (instance == null) {
            instance = new Achievement();
        }
        return instance;
    }

    public void message(String message, String name) {

        File logsFolder = new File("Achievements");
        if (!logsFolder.exists()) {
            //Create the directory
            System.err.println("INFO: Creating new logs directory!");
            logsFolder.mkdir();
        }


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        File achievement = new File("Achievements" +  File.separator + "Achievements" + name +".txt");
        if(!achievement.exists()){
            try{
                achievement.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter(achievement, true);
            fw.write("[" + dateFormat.format(new Date()) + "]" + message + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
