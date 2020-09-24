package addressbook.package1.appManager;

import addressbook.package1.model.GroupData;
import addressbook.package1.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {

        type(By.name("group_name"), groupData.getGroupName());
    }

    public void newGroupCreation() {
        click(By.name("new"));
    }



    public void selectGroupById(int id) {

        driver.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public void deleteSelectedGroups() {

        click(By.xpath("(//input[@name='delete'])[2]"));
    }


    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        newGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
    }


    public void delete(GroupData deletedGroup) {
        selectGroupById(deletedGroup.getId());
        deleteSelectedGroups();
        returnToGroupPage();
    }


    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            GroupData group = new GroupData().withId(id).withName(name);
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }


}
