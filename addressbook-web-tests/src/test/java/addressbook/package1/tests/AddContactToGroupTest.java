package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTest extends Testbase {

    private Object driver;

    @Test
    public void addContactToGroup(){
        app.goToHomePage();
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("Zhanna")
                    .withLastname("Clue"));
        }
        Contacts before = app.db().contacts();
        ContactData contactAddedToGroup= before.iterator().next();
        app.contactHelper.selectContactByID(contactAddedToGroup.getId());
        app.contactHelper.addGroupToContact();
        Contacts after = app.db().contacts();


    }

}
