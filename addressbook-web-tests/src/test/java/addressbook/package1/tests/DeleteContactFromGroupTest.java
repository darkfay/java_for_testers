package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import addressbook.package1.model.GroupData;
import addressbook.package1.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTest extends Testbase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goToHomePage();
            Groups groups = app.db().groups();
            if (groups.size() == 0) {
                app.goToGroupPage();
                app.group().create(new GroupData().withName("Beatles"));
            }
            app.contact().createContact(new ContactData()
                    .withFirstname("Name")
                    .withLastname("Last")
                    .inGroup(groups.iterator().next()));
        }
    }

    @Test
    public void deleteContactFromGroup() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        if (!contacts.stream().filter((s) -> (s.getGroups().size() > 0)).findAny().isPresent()) {
            app.contact().addContactToGroup(contacts.iterator().next(), groups.iterator().next());
        }
        ContactData deletedFromGroupContact = app.db().contacts().stream().filter((s) -> (s.getGroups().size() > 0)).findAny().get();
        Groups before = deletedFromGroupContact.getGroups();
        GroupData modifiedGroup = before.iterator().next();
        app.contact().deleteContactFromGroup(deletedFromGroupContact, modifiedGroup);
        Groups after = app.db().contacts().stream().filter((s) -> s.equals(deletedFromGroupContact)).findFirst().get().getGroups();
        assertThat(after, equalTo(before.without(modifiedGroup)));
    }
}

