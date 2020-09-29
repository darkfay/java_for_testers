package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends Testbase {
    @Test
    public void testContactPhone() {
        app.goToHomePage();
        ContactData contact = app.contactHelper.all().iterator().next();
        ContactData contactInfoFromEditForm = app.contactHelper.infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
//        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
