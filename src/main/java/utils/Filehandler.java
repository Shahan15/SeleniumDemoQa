package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties; //class to handle key value pairs

public class Filehandler {
    private Properties properties; //storing key value pairs from config file

    public Filehandler () {
        properties = new Properties();//instantiating Properties class
        readFile();
    }

    private void readFile() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.Properties");
            properties.load(fis); //loads properties from file
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getProperty(String key) {
        String results = properties.getProperty(key);
        return results;
    } //this returns the key from config

}
