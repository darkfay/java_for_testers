package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.annotations.Test;

public class GroupModifikationTests extends Testbase {

    @Test
    public void testGroupModifikation() {
        app.goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("ttest"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
