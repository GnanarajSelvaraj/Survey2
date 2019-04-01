package org.mahiti.recycler_frag;

public class UserClass {
    int id;
    String username;
    String phone_number;
    String gender;
    String hobbies;
    String dob ;
    String address;

    public UserClass(int id, String username, String phone_number, String gender, String hobbies, String dob, String address) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.gender = gender;
        this.hobbies = hobbies;
        this.dob = dob;
        this.address = address;
    }

    public UserClass(String username, String phone_number, String gender, String hobbies, String dob, String address) {
        this.username = username;
        this.phone_number = phone_number;
        this.gender = gender;
        this.hobbies = hobbies;
        this.dob = dob;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }


    public class TABLE_NAME {
    }
}
