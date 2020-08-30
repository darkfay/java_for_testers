package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends Testbase {

  @Test
  public void testGroupCreationTests() throws Exception {
    app.goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().newGroupCreation();
    GroupData group = new GroupData(0, "True");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() +1);

    group.setId(after.stream().max((g1, g2) -> Integer.compare(g1.getId(), g2.getId())). get().getId());
    before.add(group);
    Comparator<? super GroupData> byID = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }

}
