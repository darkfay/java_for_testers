package addressbook.package1.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    public WebDriver driver;
    private SessionHelper sessionHelper;
    public ContactHelper contactHelper;
    private GroupHelper groupHelper;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager() {
    }

    public void init() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
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

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public void goToHomePage() {
        driver.findElement(By.linkText("home")).click();

    }
    public void goToAddNewPage() {
        driver.findElement(By.linkText("add new")).click();

    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();

    }

}
