package addressbook.package1.appManager;

import addressbook.package1.model.ContactData;
import addressbook.package1.tests.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("(//input[@value='Delete'])"));
    }

    public void editContact(String firstname) {
        click(By.xpath("//img[@alt='Edit']"));
        type(By.name("firstname"), firstname);
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
}
