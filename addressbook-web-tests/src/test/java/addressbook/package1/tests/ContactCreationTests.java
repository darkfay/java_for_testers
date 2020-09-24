package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends Testbase {

    @Test
    public void testContactCreationTests() throws Exception {
        app.goToHomePage();
        Contacts before = app.getContactHelper().all();
        app.contactHelper.goToAddNewPage();
        ContactData contact = new ContactData()
                .withFirstname("Zhanna")
                .withLastname("DArk")
                .withAddress(null)
                .withEmail(null)
                .withPhone(null);
        app.contactHelper.fillContact(contact);
        app.contactHelper.submitContact();
        app.goToHomePage();
        Contacts after = app.getContactHelper().all();
        assertThat(after.size(), equalTo(before.size() +1));

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
//        before.add(contact);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
