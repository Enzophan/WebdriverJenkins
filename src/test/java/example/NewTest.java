package example;

import org.openqa.selenium.WebDriver;
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
        driver.get("http://demo.guru99.com/test/guru99home/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Demo Guru99 Page"));
    }

    @BeforeTest
    public void beforeTest() {
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("headless");
//        String filePath = System.getProperty("user.dir") + "/geckodriver";
//        System.out.println("Working Directory = " + filePath);
//        System.setProperty("webdriver.gecko.driver", filePath);
        driver = new FirefoxDriver(opt);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
