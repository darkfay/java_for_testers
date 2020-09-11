package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import addressbook.package1.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends Testbase {

  @Test
  public void testGroupCreationTests() throws Exception {
    app.goToGroupPage();
    Groups before = app.group().all();
    app.group().newGroupCreation();
    GroupData group = new GroupData().withName("Test2");
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() +1));

    group.withId(after.stream().max((g1, g2) -> Integer.compare(g1.getId(), g2.getId())). get().getId());
//    before.add(group);
//    assertThat(after, equalTo(before).withAdded(group));

  }

}
