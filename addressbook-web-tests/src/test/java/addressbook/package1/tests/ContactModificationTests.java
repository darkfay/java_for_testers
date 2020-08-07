package addressbook.package1.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends Testbase {

    @Test
    public void testGroupModificationTests() throws Exception {
        app.goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact(("Test1"));
        app.goToHomePage();

    }

}
