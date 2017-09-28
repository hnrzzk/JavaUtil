package conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

/**
 * Created by zhangkai on 2017/9/28.
 */
public final class Settings {

    private Settings() {
    }

    private static class SettingsHandle {
        private static Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHandle.INSTANCE;
    }

    private final HashSet<String> fileNameSet = new HashSet<String>();
    private final HashMap<String, Properties> settingsMap = new HashMap<String, Properties>();

    public void load(String fileName) {
        try {
            synchronized (settingsMap) {
                Properties properties = new Properties();
                InputStream inputStream = Settings.class.getClassLoader().getResourceAsStream(fileName);
                properties.load(inputStream);

                fileNameSet.add(fileName);
                settingsMap.put(fileName, properties);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String find(String section, String key) {
        return find(section, key, "");
    }

    public String find(String section, String key, String defaultValue) {
        synchronized (settingsMap){
            Properties properties = settingsMap.get(section);
            if ( null != properties)
            {
                return properties.getProperty(key);
            }

            return defaultValue;
        }
    }


}
