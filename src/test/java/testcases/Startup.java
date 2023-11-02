package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class Startup {
    protected WebDriver driver;
    private File projectdirectory;
    protected Properties prop;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) throws InterruptedException {
    projectdirectory = new File(System.getProperty("user.dir"));
    prop = new Properties();
    File configfile = new File(projectdirectory,"config.properties");
    try{
        FileInputStream fis = new FileInputStream(configfile.getAbsoluteFile());
        prop.load(fis);
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                driver=null;
                break;
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterTest
    public void shutdown(){
        driver.quit();
    }
}
