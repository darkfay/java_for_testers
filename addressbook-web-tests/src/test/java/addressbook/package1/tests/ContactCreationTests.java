package addressbook.package1.tests;

import addressbook.package1.model.ContactData;
import addressbook.package1.model.Contacts;
import addressbook.package1.model.GroupData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends Testbase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/addressbook/package1/resources/contacts.csv")));
        String  line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[] {new ContactData().withFirstname(split[0]).withLastname(split[1]).withMobilePhone(split[2]).withAddress(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/addressbook/package1/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreationTests(ContactData contact) throws Exception {
        app.goToHomePage();
        Contacts before = app.db().contacts();
        app.contactHelper.goToAddNewPage();
//        ContactData contact = new ContactData()
//                .withFirstname("Zhanna")
//                .withLastname("DArk");
        app.contactHelper.fillContact(contact);
        app.contactHelper.submitContact();
        app.goToHomePage();
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() +1));

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}


