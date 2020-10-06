package addressbook.package1.tests;

import addressbook.package1.appManager.ApplicationManager;
import org.openqa.selenium.devtools.browser.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Testbase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}
