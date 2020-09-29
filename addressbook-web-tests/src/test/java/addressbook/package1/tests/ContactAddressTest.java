package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends Testbase {
    @Test
    public void testAddressPhone() {
        app.goToHomePage();
        ContactData contact = app.contactHelper.all().iterator().next();
        ContactData contactInfoFromEditForm = app.contactHelper.infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddress()), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactAddressTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String address) {
        return address.replaceAll("\\s", "");
    }
}
