package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import addressbook.package1.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends Testbase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goToGroupPage();

        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("Beatles"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedGroup)));

    }


}
