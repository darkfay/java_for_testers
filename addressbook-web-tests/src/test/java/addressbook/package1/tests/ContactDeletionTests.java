package addressbook.package1.tests;

import org.testng.annotations.*;

public class ContactDeletionTests extends Testbase {

    @Test
    public void testContactDeletion() throws Exception {
        app.goToHomePage();
        app.getContactHelper().selectContact();
//        app.getContactHelper().editContacts();
        app.getContactHelper().deleteSelectedContacts();
        app.driver.switchTo().alert().accept();
        app.goToHomePage();
    }
}
