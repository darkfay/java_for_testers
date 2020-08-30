package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends Testbase {

    @Test
    public void testContactCreationTests() throws Exception {
        app.goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.contactHelper.goToAddNewPage();
        ContactData contact = new ContactData("test1","test1","test1", "test1", "test1", 0);
        app.contactHelper.fillContact(contact);
        app.contactHelper.submitContact();
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);

        contact.setId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())). get().getId());
        before.add(contact);
        Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}
