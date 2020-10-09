package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends Testbase {

    @Test
    public void testContactDeletion() throws Exception {
        app.goToHomePage();
        if (app.db().contacts().size() == 0) {
            app.getContactHelper().createContact(new ContactData()
                    .withFirstname("Zhanna")
                    .withLastname("DArk"));
        }
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.getContactHelper().selectContactByID(deletedContact.getId());
        app.getContactHelper().deleteSelectedContacts();
        app.driver.switchTo().alert().accept();
        app.goToHomePage();
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedContact)));

    }
}
