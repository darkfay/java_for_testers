package addressbook.package1.appManager;

import addressbook.package1.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

import java.util.ArrayList;
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
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("(//input[@value='Delete'])"));
    }

    public void editContact(ContactData contact, int index) {
        driver.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
        type(By.name("firstname"), contact.getFirstname());
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

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        int count = driver.findElements(By.xpath("//img[@alt='Edit']")).size();
        for (int i = 0; i < count; i++) {
            List<WebElement> elements = driver.findElements(By.cssSelector("tr[name='entry']"));
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
            driver.findElements(By.xpath("//img[@alt='Edit']")).get(i).click();
            String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
            String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
            String company = driver.findElement(By.name("company")).getAttribute("value");
            String address = driver.findElement(By.name("address")).getAttribute("value");
            String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
            ContactData contact = new ContactData(firstname, lastname, company, address, mobile, id);
            contacts.add(contact);
            driver.findElement(By.linkText("home")).click();
        }

        return contacts;
    }
}
