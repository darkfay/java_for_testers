package addressbook.package1.appManager;

import addressbook.package1.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends  HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContract() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContract(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
    }
}
