package addressbook.package1.appManager;

import jdk.jfr.events.FileReadEvent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private final Properties properties;
    public WebDriver driver;
    private SessionHelper sessionHelper;
    public ContactHelper contactHelper;
    private GroupHelper groupHelper;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    private String browser;
    private DbHelper dbHelper;


    public ApplicationManager(String browser)  {
        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/java/addressbook/package1/resources/%s.properties", target))));

        dbHelper = new DbHelper();

        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
//            ChromeDriverService service = new ChromeDriverService.Builder()
//                    .withLogFile(new File("chromedriver.log")).withVerbose(true).build();
//            driver = new ChromeDriver(service);
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }
//        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.baseUrl"));
        groupHelper = new GroupHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

    }


    public void logOut() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public GroupHelper group() {

        return groupHelper;
    }

    public ContactHelper getContactHelper() {

        return contactHelper;
    }

    public void goToHomePage() {
        driver.findElement(By.linkText("home")).click();

    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();

    }

    public DbHelper db(){
        return dbHelper;
    }

}
