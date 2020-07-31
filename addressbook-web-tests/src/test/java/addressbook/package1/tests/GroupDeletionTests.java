package addressbook.package1.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends Testbase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getGroupHelper().selectGroup();
    app.deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
