package addressbook.package1.appManager;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        type(By.name("email"), contactData.getEmail());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getPhone());
    }


    public void selectContactByID(int id) {
        driver.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public WebElement getContactByID(int id) {
        return driver.findElement(By.cssSelector("input[value='"+id+"']"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("(//input[@value='Delete'])"));
    }


    public void editContact(ContactData contact) {
        selectContactByID(contact.getId());
        List<WebElement> elements = driver.findElements(By.cssSelector("td input"));
        WebElement element = getContactByID(contact.getId());
        int index = elements.indexOf(element);
        click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));
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
            String phone = cells.get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname));
//                    .withAddress(address)
//                    .withEmail(email)
//                    .withPhone(phone));
//            driver.findElement(By.linkText("home")).click();
        }
        return contacts;
    }

}
