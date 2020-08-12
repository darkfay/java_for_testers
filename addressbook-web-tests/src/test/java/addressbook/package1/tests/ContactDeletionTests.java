package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import org.testng.annotations.*;

public class ContactDeletionTests extends Testbase {

    @Test
    public void testContactDeletion() throws Exception {
        app.goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test","test","test", "test", "test"));
        }
        app.getContactHelper().selectContact();
//        app.getContactHelper().editContacts();
        app.getContactHelper().deleteSelectedContacts();
        app.driver.switchTo().alert().accept();
        app.goToHomePage();
    }
}
