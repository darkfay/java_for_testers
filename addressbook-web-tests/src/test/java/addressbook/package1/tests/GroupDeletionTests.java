package addressbook.package1.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends Testbase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
