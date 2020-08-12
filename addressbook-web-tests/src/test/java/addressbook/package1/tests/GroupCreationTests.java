package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.annotations.*;


public class GroupCreationTests extends Testbase {

  @Test
  public void testGroupCreationTests() throws Exception {
    app.getGroupHelper().newGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData(null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    app.logOut();
  }

}
