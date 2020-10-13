package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import addressbook.package1.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupModifikationTests extends Testbase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goToGroupPage();
            app.group().create(new GroupData().withName("PinkFloyd"));
        }
    }

    @Test(enabled = false)
    public void testGroupModifikation() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("LedZeppelin");
        app.goToGroupPage();
        app.group().modify(group);
        assertEquals(app.group().count(), before.size());
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();


    }
}
