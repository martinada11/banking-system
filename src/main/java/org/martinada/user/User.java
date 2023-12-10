package org.martinada.user;

import org.martinada.account.Account;
import org.martinada.utils.EmailValidator;
import org.martinada.utils.PhoneNumberValidator;
import org.martinada.utils.PostCodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Configuration
@ComponentScan
public class User {
    private Integer UserId;
    private String firstName;
    private String lastName;
    private UserTypes type;
    private String address;
    private String city;
    private String postCode;
    private String phoneNumber;
    private String email;
    private Account account;
    private PostCodeValidator pcv;
    private EmailValidator ev;
    private PhoneNumberValidator pnv;

    public User() {}
    public User(
            String firstName,
            String lastName,
            boolean isAdmin,
            String address,
            String city,
            String postCode,
            String phoneNumber,
            String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
        this.email = email;

        if (isAdmin) {
            this.type = type.CLERK;
        } else {
            this.type = type.ACCOUNT_HOLDER;
        }

    }

    public User(
            String firstName,
            String lastName,
            boolean isAdmin,
            String address,
            String city,
            String postCode,
            String phoneNumber,
            String email,
            Account account,
            PostCodeValidator pcv,
            PhoneNumberValidator pnv,
            EmailValidator ev) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.pcv = pcv;
        this.pnv = pnv;
        this.ev = ev;

        if (isAdmin) {
            this.type = type.CLERK;
        } else {
            this.type = type.ACCOUNT_HOLDER;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserTypes getType() {
        return type;
    }

    public void setType(UserTypes type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        if (!pcv.isPostCodeValid(postCode)) {
            this.phoneNumber = null;
        } else {
            this.postCode = postCode;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!pnv.isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = null;
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!ev.isEmailAddressValid(email)) {
            this.email = null;
        } else {
            this.email = email;
        }


    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type=" + type +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                ", pcv=" + pcv +
                ", ev=" + ev +
                ", pnv=" + pnv +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(UserId, user.UserId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && type == user.type && Objects.equals(address, user.address) && Objects.equals(city, user.city) && Objects.equals(postCode, user.postCode) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(account, user.account) && Objects.equals(pcv, user.pcv) && Objects.equals(ev, user.ev) && Objects.equals(pnv, user.pnv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, firstName, lastName, type, address, city, postCode, phoneNumber, email, account, pcv, ev, pnv);
    }
}
