package addressbook.package1.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name="addressbook")
public class ContactData {
@Id
@Column(name="id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name="firstname")
    private String firstname;
    @Expose
    @Column(name="lastname")
    private String lastname;
    @Transient
    private String email;
    @Expose
    @Column(name="address")
    @Type(type="text")
    private String address;
    @Expose
    @Column(name="mobile")
    @Type(type="text")
    private String mobilePhone;
    @Column(name="home")
    @Type(type="text")
    private String homePhone;
    @Column(name="work")
    @Type(type="text")
    private String workPhone;
    @Transient
    private String allPhones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mobilePhone, that.mobilePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, address, mobilePhone);
    }

    @Transient
    private String email2;
    @Transient
    private String email3;
    @Transient
    private String group;
    @Transient
    private File photo;

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public File getPhoto() {
        return photo;
    }



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
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
//                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
