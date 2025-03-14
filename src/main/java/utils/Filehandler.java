package utils;
import java.io.FileInputStream;
import java.util.Properties; //class to handle key value pairs
import static java.nio.file.FileSystems.getDefault;

public class Filehandler {

    static Properties properties = new Properties();//instantiating Properties class

    //To make code more dynamic and portable need to build file path dynamically
    //Fs will get the system seperator e.g. / or \
    //dir will get the user directory
    public static String Fs = getDefault().getSeparator();
    public static String dir = System.getProperty("user.dir");
    public static String ConfigPath = dir + Fs + "src" + Fs + "main" + Fs + "resources" + Fs;
    public static String ConfigFile = ConfigPath + "config.properties";

    public static String reports = ConfigPath + "reports" + Fs;
    public static String screenshotPath = ConfigPath + Fs;

    public static String readFile(String strKey)  {
        String result="";
        try {
            FileInputStream fis = new FileInputStream(ConfigFile);
            properties.load(fis); //loads properties from file
            result = properties.getProperty(strKey);
        }catch (Exception e) {
            e.getMessage();
        }
        return result;
    }


    public static String getProperty(String key) {
        String results = properties.getProperty(key);
        return results;
    } //this returns the key from config.properties
}
