package com.example.college_student;

public class StudentActivity {

   private int age;
    private int imageId;
   private String fullname, address, gender;

    public StudentActivity(int age, int imageId, String fullname, String address, String gender) {
        this.age = age;
        this.imageId = imageId;
        this.fullname = fullname;
        this.address = address;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
