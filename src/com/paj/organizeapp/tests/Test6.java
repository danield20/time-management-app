package com.paj.organizeapp.tests;

import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.activities.Project;
import com.paj.organizeapp.activities.ProjectType;
import com.paj.organizeapp.people.WorkColleague;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("Duplicates")
public class Test6 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testProject() {
        Project project = new Project("FirstProject", ProjectType.WorkProject, LocalDateTime.parse("2022-10-12 12:00", formatter));

        assertEquals("FirstProject", project.getName());
        assertEquals(ProjectType.WorkProject, project.getType());
        assertEquals("2022-10-12T12:00", project.getDeadline().toString());

        project.setName("SecondProject");
        project.setType(ProjectType.SportActivity);
        project.setDeadline(LocalDateTime.parse("2022-10-13 12:00", formatter));

        assertEquals("SecondProject", project.getName());
        assertEquals(ProjectType.SportActivity, project.getType());
        assertEquals("2022-10-13T12:00", project.getDeadline().toString());

        WorkColleague workcolleague1 = new WorkColleague("George", 30, "male", "Cloud", "george@google.com", false);
        WorkColleague workcolleague2 = new WorkColleague("George", 31,"male", "Cloud", "george2@google.com", false);
        WorkColleague workcolleague3 = new WorkColleague("George3", 32,"male","Cloud", "george3@google.com", false);
        WorkColleague workcolleague4 = new WorkColleague("George4", 33,"male","Cloud", "george4@google.com", false);

        project.addParticipant(workcolleague1);
        project.addParticipant(workcolleague2);
        project.addParticipant(workcolleague3);
        project.addParticipant(workcolleague4);

        assertEquals(4, project.getParticipants().size());

        project.removeParticipantByName("George", 1);

        assertEquals(31, project.getParticipants().get(0).getAge());

    }
}
