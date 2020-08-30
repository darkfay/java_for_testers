package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.HashSet;

public class ContactModificationTests extends Testbase {

    @Test
    public void testContactModification() throws Exception {
        app.goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test","test","test", "test", "test", 0));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        ContactData contact = new ContactData("New name", before.get(before.size()-1).getLastname(), before.get(before.size()-1).getCompany(), before.get(before.size()-1).getAddress(),before.get(before.size()-1).getMobile(),before.get(before.size()-1).getId());

        app.getContactHelper().editContact(contact, before.size() -1);
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);



    }

}
