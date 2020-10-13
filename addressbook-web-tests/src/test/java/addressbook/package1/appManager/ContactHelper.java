package addressbook.package1.appManager;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import addressbook.package1.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.naming.Name;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContact(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
    }


    public void selectContactByID(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public WebElement getContactByID(int id) {
        return driver.findElement(By.cssSelector("input[value='" + id + "']"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("(//input[@value='Delete'])"));
    }


    public void editContact(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContact(contact);
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void goToAddNewPage() {
        driver.findElement(By.linkText("add new")).click();

    }

    public void createContact(ContactData contact) {
        goToAddNewPage();
        fillContact(contact);
        submitContact();

    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }


    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }


    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = driver.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String mobilePhone = cells.get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withAddress(address)
                    .withMobilePhone(mobilePhone));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String email = driver.findElement(By.name("email")).getAttribute("value");
        String mobilePhone = driver.findElement(By.name("mobile")).getAttribute("value");
        String homePhone = driver.findElement(By.name("home")).getAttribute("value");
        String workPhone = driver.findElement(By.name("work")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        driver.navigate().back();
        ContactData contactData = new ContactData()
                .withId(contact.getId())
                .withAddress(address)
                .withEmail(email)
                .withFirstname(firstname)
                .withLastname(lastname)
                .withMobilePhone(mobilePhone)
                .withHomePhone(homePhone)
                .withWorkPhone(workPhone)
                .withEmail2(email2)
                .withEmail3(email3);
        return contactData;

    }

    public void initContactModificationById(int id) {
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }



    public void addGroup() {
        driver.findElement(By.name("add")).click();
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        selectContactByID(contact.getId());
        new Select(driver.findElement(By.name("to_group"))).selectByValue(Integer.toString(group.getId()));
        addGroup();
    }


    public void deleteContactFromGroup(ContactData contact, GroupData group) {
        new Select(driver.findElement(By.name("group"))).selectByValue(Integer.toString(group.getId()));
        selectContactByID(contact.getId());
        DeleteFromGroup();
    }


    private void DeleteFromGroup() {
        driver.findElement(By.name("remove")).click();
    }


}
