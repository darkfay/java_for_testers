package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends Testbase {

    @Test
    public void testContactDeletion() throws Exception {
        app.goToHomePage();
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("Zhanna")
                    .withLastname("DArk"));
        }
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().selectContactByID(deletedContact.getId());
        app.contact().deleteSelectedContacts();
        app.driver.switchTo().alert().accept();
        app.goToHomePage();
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedContact)));

    }
}
