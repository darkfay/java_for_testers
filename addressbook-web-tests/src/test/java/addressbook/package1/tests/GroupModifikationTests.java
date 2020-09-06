package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.SetMultiMap;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


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

        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("LedZeppelin");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
