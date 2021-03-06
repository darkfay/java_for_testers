package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends Testbase {
    @Test
    public void testContactEmail() {
        app.goToHomePage();
        ContactData contact = app.contactHelper.all().iterator().next();
        ContactData contactInfoFromEditForm = app.contactHelper.infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactEmailTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email) {
        return email.replaceAll("\\s", "");
    }
}

