package addressbook.package1.tests;

import java.util.concurrent.TimeUnit;

import addressbook.package1.model.ContactData;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests extends Testbase {

    @Test
    public void testContactCreationTests() throws Exception {
        app.goToAddNewPage();
        app.contactHelper.fillContract(new ContactData("test","test","test", "test", "test"));
        app.contactHelper.submitContract();
        app.goToHomePage();
    }
}
