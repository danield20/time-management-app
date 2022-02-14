package com.paj.organizeapp.tests;

import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.activities.WorkActivity;
import com.paj.organizeapp.email.EmailService;
import com.paj.organizeapp.main.OrganizeApp;
import com.paj.organizeapp.people.AppUser;
import com.paj.organizeapp.people.WorkColleague;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings({"Duplicates"})

public class Test4 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testEmail() throws Exception {
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

        wrk1.addParticipant(workcolleague1);
        wrk1.addParticipant(workcolleague2);
        wrk1.addParticipant(workcolleague3);
        wrk1.addParticipant(workcolleague4);

        OrganizeApp app = new OrganizeApp();
        EmailService service = app.getEmailService();
        AppUser me = app.getUser();

        wrk1.sendEmailToParticipants(me, "MailTest", "Test message", service);

        assertEquals(4, service.getSentEmails());

        service.close();
        wrk1.sendEmailToParticipants(me, "MailTest", "Test message", service);
        assertEquals(4, service.getSentEmails());

    }
}
