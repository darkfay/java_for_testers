package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends Testbase {

    @Test
    public void testContactCreationTests() throws Exception {
        app.contactHelper.goToAddNewPage();
        app.contactHelper.fillContact(new ContactData("test","test","test", "test", "test"));
        app.contactHelper.submitContact();
        app.goToHomePage();
    }
}
