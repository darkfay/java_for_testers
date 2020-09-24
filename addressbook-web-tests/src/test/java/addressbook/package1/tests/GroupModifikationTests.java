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
        app.goToGroupPage();

        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("PinkFloyd"));
        }
    }

    @Test
    public void testGroupModifikation() {

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("LedZeppelin");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }


}
