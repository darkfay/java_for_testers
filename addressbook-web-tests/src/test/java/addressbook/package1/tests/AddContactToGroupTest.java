package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.GroupData;
import addressbook.package1.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTest extends Testbase {

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
    public void TestAddContactToGroup() {
        Groups groups = app.db().groups();
        ContactData contactAddedToGroup =
                app.db().contacts().stream().filter((s) -> (s.getGroups().size() < groups.size())).findAny().get();
        Groups before = contactAddedToGroup.getGroups();
        GroupData group = groups.without(contactAddedToGroup.getGroups()).iterator().next();
        app.contact().addContactToGroup(contactAddedToGroup, group);
        app.goToHomePage();
        Groups after = app.db().contacts().stream().filter((s) -> s.equals(contactAddedToGroup)).findFirst().get().getGroups();
        assertThat(after, equalTo(before.withAdded(group)));
    }
}


