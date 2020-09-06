package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;

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
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }


}
