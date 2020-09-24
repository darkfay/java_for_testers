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
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData()
                    .withFirstname("Zhanna")
                    .withLastname("D'Ark")
                    .withAddress(null)
                    .withEmail(null)
                    .withPhone(null)
                    .withId(0));
        }
        Contacts before = app.getContactHelper().all();
        ContactData deletedContact = before.iterator().next();
        app.getContactHelper().selectContactByID(deletedContact.getId());
        app.getContactHelper().deleteSelectedContacts();
        app.driver.switchTo().alert().accept();
        app.goToHomePage();
        Contacts after = app.getContactHelper().all();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedContact)));

    }
}
