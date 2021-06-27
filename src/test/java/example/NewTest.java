package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
    private WebDriver driver;

    @Test
    public void testEasy() {
        driver.get("https://vnexpress.net/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("VnExpress - Báo tiếng Việt nhiều người xem nhất"));
    }

    @BeforeTest
    public void beforeTest() {
        String filePath = System.getProperty("user.dir") + "/geckodriver";
        System.out.println("Working Directory = " + filePath);
        System.setProperty("webdriver.gecko.driver", filePath);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);

//        String filePath = System.getProperty("user.dir") + "/chromedriver";
//        System.out.println("Working Directory = " + filePath);
//        System.setProperty("webdriver.chrome.driver", filePath);
//        //ChromeOptions object
//        ChromeOptions opt = new ChromeOptions();
//        //headless parameter
//        opt.addArguments("headless");
//        // set parameter to Chrome driver
//        driver = new ChromeDriver(opt);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
