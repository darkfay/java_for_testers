package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends Testbase {

    @Test
    public void testContactModification() throws Exception {
        app.goToHomePage();
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("Zhanna")
                    .withLastname("DArk"));
        }

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstname("Neon")
                .withLastname("Bart")
                .withAddress("Pis")
                .withMobilePhone("21");
        app.contact().editContact(contact);
        app.goToHomePage();
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));




    }

}
