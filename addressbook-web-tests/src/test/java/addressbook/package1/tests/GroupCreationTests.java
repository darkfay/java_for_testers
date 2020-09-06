package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class GroupCreationTests extends Testbase {

  @Test
  public void testGroupCreationTests() throws Exception {
    app.goToGroupPage();
    Set<GroupData> before = app.group().all();
    app.group().newGroupCreation();
    GroupData group = new GroupData().withName("Test2");
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() +1);

    group.withId(after.stream().max((g1, g2) -> Integer.compare(g1.getId(), g2.getId())). get().getId());
    before.add(group);
    Assert.assertEquals(before, after);
  }

}
