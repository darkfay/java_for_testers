package addressbook.package1.tests;

import addressbook.package1.model.GroupData;
import org.testng.annotations.Test;

public class GroupModifikationTests extends Testbase {

    @Test
    public void testGroupModifikation() {
        app.goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("James.B"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("James.B"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
