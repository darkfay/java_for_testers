package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.GroupData;
import org.testng.annotations.Test;

public class ContactModificationTests extends Testbase {

    @Test
    public void testContactModification() throws Exception {
        app.goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test","test","test", "test", "test"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact(("Test1"));
        app.goToHomePage();

    }

}
