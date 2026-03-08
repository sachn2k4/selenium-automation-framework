package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("config.properties file not found! " + e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicit.wait"));
    }

    public static String getValidUsername() {
        return properties.getProperty("valid.username");
    }

    public static String getValidPassword() {
        return properties.getProperty("valid.password");
    }

    public static String getInvalidUsername() {
        return properties.getProperty("invalid.username");
    }

    public static String getInvalidPassword() {
        return properties.getProperty("invalid.password");
    }

    public static String getReportPath() {
        return properties.getProperty("report.path");
    }

    public static String getScreenshotPath() {
        return properties.getProperty("screenshot.path");
    }
}
