package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import org.testng.annotations.Test;

public class ContactPhoneTest extends Testbase{
    @Test
    public void testContactPhone(){
        app.goToGroupPage();
        ContactData contact = app.contactHelper.all().iterator().next();
        ContactData contactInfoFromEditForm = app.contactHelper.infoFromEditForm(contact);
    }
}
