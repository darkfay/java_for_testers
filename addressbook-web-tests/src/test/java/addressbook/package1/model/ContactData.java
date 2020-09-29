package addressbook.package1.model;

import java.util.Objects;

public class ContactData {
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;
    private String allPhones;
    private String email2;
    private String email3;

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    private int id = Integer.MAX_VALUE;

//    public ContactData(String firstname, String lastname, String email, String address, String phone, int id) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.address = address;
//        this.phone = phone;
//        this.id = id;
//    }

    public String getFirstname() { return firstname; }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getId() { return id; }

    public String getMobilePhone() {return mobilePhone; };

    public String getWorkPhone() {return workPhone; };

    public String getHomePhone() {return homePhone; }

    public ContactData withId(int id) {

        this.id=id;
        return this;
    }
    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
//                Objects.equals(email, that.email) &&
//                Objects.equals(address, that.address) &&
//                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, address, mobilePhone, id);
    }




    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + mobilePhone + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
