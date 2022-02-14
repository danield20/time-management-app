package com.paj.organizeapp.tests;
import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.activities.Project;
import com.paj.organizeapp.activities.ProjectType;
import com.paj.organizeapp.people.WorkColleague;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("Duplicates")
public class Test7 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testSocialOperations() {
        Project project = new Project("FirstProject", ProjectType.WorkProject, LocalDateTime.parse("2022-10-12 12:00", formatter));

        WorkColleague workcolleague1 = new WorkColleague("George", 30, "male", "Cloud", "george@google.com", false);
        WorkColleague workcolleague2 = new WorkColleague("Alice", 31,"female", "QA", "alice@google.com", true);
        WorkColleague workcolleague3 = new WorkColleague("George2", 32,"male","Cloud", "george2@google.com", false);
        WorkColleague workcolleague4 = new WorkColleague("Alice2", 33,"female","Cloud", "alice2@google.com", true);

        project.addParticipant(workcolleague1);
        project.addParticipant(workcolleague2);
        project.addParticipant(workcolleague3);
        project.addParticipant(workcolleague4);

        assertEquals(2, project.getFemales().size());
        assertEquals(2, project.getMales().size());
        assertEquals(2, project.getBiggerThanAge(32).size());
        assertEquals("George2", project.getBiggerThanAge(32).get(0).getName());
        assertEquals("George", project.getYoungest().getName());
        assertEquals("Alice2", project.getOldest().getName());
    }
}
