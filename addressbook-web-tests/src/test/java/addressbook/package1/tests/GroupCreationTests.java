package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import addressbook.package1.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends Testbase {

  @Test
  public void testGroupCreationTests() throws Exception {
    app.goToGroupPage();
    Groups before = app.group().all();
    app.group().newGroupCreation();
    GroupData group = new GroupData().withName("Brimmy");
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    assertThat(app.group().count(), equalTo(before.size() +1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

  @Test
  public void testBadGroupCreationTests() throws Exception {
    app.goToGroupPage();
    Groups before = app.group().all();
    app.group().newGroupCreation();
    GroupData group = new GroupData().withName("Jiffy'");
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size()));


    assertThat(after, equalTo(before));

  }
}
