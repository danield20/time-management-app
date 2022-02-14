package com.paj.organizeapp.tests;

import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.people.AppUser;
import com.paj.organizeapp.people.Friend;
import com.paj.organizeapp.people.WorkColleague;
import org.junit.Test;

public class Test2 {

    @Test
    public void testUsers() {
        Friend friend1 = new Friend("Alice", 24, "female", "+40761234567", "alice@gmail.com", 4);
        WorkColleague workcolleague1 = new WorkColleague("George", 30, "male", "Cloud", "george@google.com", false);
        AppUser appUser = AppUser.getInstance();

        assertEquals("Alice", friend1.getName());
        assertEquals(24, friend1.getAge());
        assertEquals(4, friend1.getYears_of_friendship());
        assertEquals("+40761234567", friend1.getPhoneNumber());
        assertEquals("alice@gmail.com", friend1.getEmail());

        friend1.setPhoneNumber("+40761234333");
        friend1.setYears_of_friendship(10);
        friend1.setEmail("alice@yahoo.com");


        assertEquals("+40761234333", friend1.getPhoneNumber());
        assertEquals("alice@yahoo.com", friend1.getEmail());
        assertEquals(10, friend1.getYears_of_friendship());

        assertEquals("George", workcolleague1.getName());
        assertEquals(30, workcolleague1.getAge());
        assertEquals("Cloud", workcolleague1.getTeam());
        assertEquals("george@google.com", workcolleague1.getEmail());
        assertEquals(false, workcolleague1.isSuperior());

        workcolleague1.setEmail("george@amazon.com");
        workcolleague1.setSuperior(true);
        workcolleague1.setTeam("Test");

        assertEquals("Test", workcolleague1.getTeam());
        assertEquals("george@amazon.com", workcolleague1.getEmail());
        assertEquals(true, workcolleague1.isSuperior());


        assertEquals("Daniel", appUser.getName());
        assertEquals(24, appUser.getAge());
    }
}
