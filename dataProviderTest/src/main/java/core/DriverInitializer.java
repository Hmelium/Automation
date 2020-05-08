package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverInitializer {
    private static WebDriver driver;
    private static Properties properties = null;

    public static WebDriver setUp() {
        try {
            properties = new Properties();
            properties.load(Objects.requireNonNull(DriverInitializer.class.getClassLoader()
                    .getResourceAsStream("application.properties")));
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the application.properties file.");
    }

    public static String getProperty(String key) {
        return properties == null ? null : properties.getProperty(key, "");
    }
}
