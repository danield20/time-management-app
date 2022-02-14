package com.paj.organizeapp.people;

public class AppUser extends AbstractPeople {
    private static AppUser single_instance = null;

    private AppUser(String name, int age, String gender) {
        super(name, age, gender);
    }

    public static AppUser getInstance()
    {
        if (single_instance == null)
            single_instance = new AppUser("Daniel", 24, "male");

        return single_instance;
    }
}
