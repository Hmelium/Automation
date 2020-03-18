import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class BaseTest {

    public WebDriver driver;

    public void initializeWebDriver(DriverType type) {
        switch (type) {
            case IE:
                driver = createIEDriver();
                break;
            case CHROME:
                driver = createChromeDriver();
                break;
            default:
                throw new RuntimeException("Unknown driver type");
        }
    }

    private WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        return new ChromeDriver();
    }

    protected WebDriver createIEDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("ignoreProtectedModeSettings", true);
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        return driver;
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File source = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("Screenshots\\"
                        + result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeTest
    public void manageWebDriver() {
        driver.manage().window().maximize();
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
