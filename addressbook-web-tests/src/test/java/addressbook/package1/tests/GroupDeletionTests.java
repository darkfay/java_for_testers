package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.annotations.*;

public class GroupDeletionTests extends Testbase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("James.B"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
