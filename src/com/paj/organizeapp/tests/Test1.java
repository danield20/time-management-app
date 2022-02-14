package com.paj.organizeapp.tests;

import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.activities.PersonalActivity;
import com.paj.organizeapp.activities.WorkActivity;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Test1 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testWorkActivity() {

        WorkActivity wrk1 = new WorkActivity(1,
                LocalDateTime.parse("2022-10-10 12:00", formatter),
                LocalDateTime.parse("2022-10-12 12:00", formatter),
                "Activity1",
                "Google",
                "310",
                "Bucharest"
        );

        assertEquals(1, wrk1.getId());
        assertEquals("Google", wrk1.getCompany());
        assertEquals("2022-10-12T12:00", wrk1.getEndTime().toString());
        assertEquals("Bucharest", wrk1.getOffice());
        assertEquals("310", wrk1.getMeeting_room());

        wrk1.setCompany("Amazon");
        wrk1.setMeeting_room("400");
        wrk1.setOffice("London");

        assertEquals("Amazon", wrk1.getCompany());
        assertEquals("London", wrk1.getOffice());
        assertEquals("400", wrk1.getMeeting_room());

    }

    @Test
    public void testPersonalActivity() {
        PersonalActivity pers1 = new PersonalActivity(2,
                LocalDateTime.parse("2022-10-10 12:00", formatter),
                LocalDateTime.parse("2022-10-12 12:00", formatter),
                "PersonalActivity1",
                "Centrul vechi"
        );

        assertEquals(2, pers1.getId());
        assertEquals("PersonalActivity1", pers1.getName());
        assertEquals("2022-10-10T12:00", pers1.getStartTime().toString());
        assertEquals("2022-10-12T12:00", pers1.getEndTime().toString());
        assertEquals("Centrul vechi", pers1.getPlace());

    }


}
