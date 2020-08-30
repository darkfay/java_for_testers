package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ContactDeletionTests extends Testbase {

    @Test
    public void testContactDeletion() throws Exception {
        app.goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test","test","test", "test", "test", 0));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteSelectedContacts();
        app.driver.switchTo().alert().accept();
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
