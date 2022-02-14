package com.paj.organizeapp.people;

public class Friend extends AbstractPeople {
    private String phoneNumber;
    private String email;
    private int years_of_friendship;

    public Friend(String name, int age, String gender, String phoneNumber, String email, int years_of_friendship) {
        super(name, age, gender);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.years_of_friendship = years_of_friendship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYears_of_friendship() {
        return years_of_friendship;
    }

    public void setYears_of_friendship(int years_of_friendship) {
        this.years_of_friendship = years_of_friendship;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", years_of_friendship=" + years_of_friendship +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
