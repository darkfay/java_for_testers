package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends Testbase {

    @Test
    public void testContactModification() throws Exception {
        app.goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData()
                    .withFirstname("Zhanna")
                    .withLastname("DArk"));
        }
        Contacts before = app.getContactHelper().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstname("Napoleon")
                .withLastname("Bonapart")
                .withAddress("Paris");
        app.getContactHelper().editContact(contact);
        app.goToHomePage();
        Contacts after = app.getContactHelper().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));


    }

}
