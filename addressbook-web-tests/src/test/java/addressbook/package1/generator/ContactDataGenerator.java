package addressbook.package1.generator;

import addressbook.package1.model.ContactData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = generateContacts(count);
        save(contacts,file);

    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i<count; i++){
            contacts.add(new ContactData()
                    .withFirstname(String.format("firstname %s", i))
                    .withLastname(String.format("lastname %s", i))
                    .withMobilePhone(String.format("phone %s", i))
                    .withAddress(String.format("address %s", i)));

        }

        return contacts;
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();

    }

//    private static void save (List<ContactData> contacts, File file) throws IOException {
//        System.out.println(new File(".").getAbsolutePath());
//        Writer writer = new FileWriter(file);
//        for (ContactData contact: contacts){
//            writer.write(String.format("%s, %s, %s,%s \n",
//                    contact.getFirstname(), contact.getLastname(), contact.getHomePhone(), contact.getAddress()));
//        }
//        writer.close();

    }



