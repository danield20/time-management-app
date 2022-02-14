package com.paj.organizeapp.tests;

import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.activities.WorkActivity;
import com.paj.organizeapp.people.AbstractPeople;
import com.paj.organizeapp.people.WorkColleague;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

@SuppressWarnings("Duplicates")
public class Test3 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testParticipantsActivity() {
        WorkColleague workcolleague1 = new WorkColleague("George", 30, "male", "Cloud", "george@google.com", false);
        WorkColleague workcolleague2 = new WorkColleague("George2", 31,"male", "Cloud", "george2@google.com", false);
        WorkColleague workcolleague3 = new WorkColleague("George3", 32,"male","Cloud", "george3@google.com", false);
        WorkColleague workcolleague4 = new WorkColleague("George4", 33,"male","Cloud", "george4@google.com", false);


        WorkActivity wrk1 = new WorkActivity(1,
                LocalDateTime.parse("2022-10-10 12:00", formatter),
                LocalDateTime.parse("2022-10-12 12:00", formatter),
                "Activity1",
                "Google",
                "310",
                "Bucharest"
        );

        LinkedList<AbstractPeople> aux = new LinkedList<>();
        aux.add(workcolleague1);
        aux.add(workcolleague2);
        aux.add(workcolleague3);
        aux.add(workcolleague4);
        aux.add(workcolleague4);


        wrk1.addParticipant(workcolleague1);
        wrk1.addParticipant(workcolleague2);
        wrk1.addParticipant(workcolleague3);
        wrk1.addParticipant(workcolleague4);

        assertEquals(4, wrk1.getParticipants().size());
        assertEquals("George", wrk1.getParticipants().get(0).getName());

        wrk1.setParticipants(aux);

        assertEquals(5, wrk1.getParticipants().size());
    }
}
