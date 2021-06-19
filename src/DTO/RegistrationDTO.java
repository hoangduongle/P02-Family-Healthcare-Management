/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author ASUS
 */
public class RegistrationDTO implements Serializable, Comparable<RegistrationDTO> {

    String registrationID;
    String fullName;
    int age;
    boolean gender;
    String email;
    String phone;
    String address;
    int numberOfMember;
    int numberOfChildren;
    int numberOfAdults;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registrationID, String fullName, int age, boolean gender, String email, String phone, String address, int numberOfMember, int numberOfChildren, int numberOfAdults) {
        this.registrationID = registrationID;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.numberOfMember = numberOfMember;
        this.numberOfChildren = numberOfChildren;
        this.numberOfAdults = numberOfAdults;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public String toString() {
        return registrationID + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", numberOfMember=" + numberOfMember + ", numberOfChildren=" + numberOfChildren + ", numberOfAdults=" + numberOfAdults + '}';
    }
//>0 1
    @Override
    public int compareTo(RegistrationDTO o) {
        if (fullName.compareTo(o.getFullName()) > 0) {
            return 1; //sx tăng theo tên
        } else if (fullName.compareTo(o.getFullName()) < 0) {
            return -1;
        }
        return 0;
    }
}
