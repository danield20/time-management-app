package com.paj.organizeapp.tests;
import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.activities.*;
import com.paj.organizeapp.main.OrganizeApp;
import com.paj.organizeapp.people.Friend;
import com.paj.organizeapp.people.WorkColleague;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("Duplicates")
public class Test8 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testActivitiesOperations() throws Exception {
        OrganizeApp app = new OrganizeApp();

        WorkColleague workcolleague1 = new WorkColleague("George", 30, "male", "Cloud", "george@google.com", false);
        WorkColleague workcolleague2 = new WorkColleague("Alice", 31,"female", "QA", "alice@google.com", true);
        WorkColleague workcolleague3 = new WorkColleague("George2", 32,"male","Cloud", "george2@google.com", false);
        WorkColleague workcolleague4 = new WorkColleague("Alice2", 33,"female","Cloud", "alice2@google.com", true);

        WorkActivity wrk1 = new WorkActivity(1,
                LocalDateTime.parse("2022-10-10 12:00", formatter),
                LocalDateTime.parse("2022-10-12 12:00", formatter),
                "WorkActivity1",
                "Google",
                "310",
                "Bucharest"
        );
        wrk1.addParticipant(workcolleague1);
        wrk1.addParticipant(workcolleague2);


        WorkActivity wrk2 = new WorkActivity(1,
                LocalDateTime.parse("2022-04-16 12:00", formatter),
                LocalDateTime.parse("2022-05-20 12:00", formatter),
                "WorkActivity2",
                "Google",
                "400",
                "Bucharest"
        );
        wrk2.addParticipant(workcolleague3);
        wrk2.addParticipant(workcolleague4);

        PersonalActivity pers1 = new PersonalActivity(2,
                LocalDateTime.parse("2022-10-22 12:00", formatter),
                LocalDateTime.parse("2022-10-24 12:00", formatter),
                "PersonalActivity1",
                "Centrul vechi"
        );

        Friend friend1 = new Friend("Iuliana", 24, "female", "+40761234567", "iuliana@gmail.com", 4);
        Friend friend2 = new Friend("Bogdan", 25, "male", "+40761284567", "bogdan@gmail.com", 8);
        Friend friend3 = new Friend("Cristi", 26, "male", "+40761284563", "cristi@gmail.com", 2);
        pers1.addParticipant(friend1);
        pers1.addParticipant(friend2);
        pers1.addParticipant(friend3);

        app.addActivity(wrk1);
        app.addActivity(wrk2);
        app.addActivity(pers1);

        assertEquals("PersonalActivity1", app.getActivitiesDescending().get(0).getName());
        assertEquals("WorkActivity2", app.getActivitiesByMonth(Month.APRIL).get(0).getName());
        assertEquals(2, app.getWorkActivities().size());
        assertEquals(1, app.getPersonalActivities().size());

    }

    @Test
    public void testGoalsOperations() throws Exception {
        OrganizeApp app = new OrganizeApp();

        Goal goal = new Goal("Weight Goal", "Losing first 10kg", false);
        Goal goal2 = new Goal("Job Goal", "Getting my first job", true);
        Goal goal3 = new Goal("Travel Goal", "Travel to 3 countries", false);

        app.addGoal(goal);
        app.addGoal(goal2);
        app.addGoal(goal3);

        assertEquals(2, app.getUnachievedGoals().size());
        assertEquals(1, app.getAchievedGoals().size());

        app.setGoalByName("Weight Goal");

        assertEquals(true, app.getGoalByName("Weight Goal").isAchieved());
    }


    @Test
    public void testFinancialOperations() throws Exception {
        OrganizeApp app = new OrganizeApp();

        Income income = new Income(1000, "Bursa");
        Income income2 = new Income(500, "Parinti");

        Spending spending = new Spending(200, "Cumparaturi");
        Spending spending2 = new Spending(700, "Excursie");

        app.addFinancial(income);
        app.addFinancial(income2);
        app.addFinancial(spending);
        app.addFinancial(spending2);

        assertEquals(600, app.getBalance());
        assertEquals(700, (long)app.getLargestSpending());
        assertEquals(1000, (long)app.getLargetIncome());
    }

    @Test
    public void testProjects() throws Exception {
        OrganizeApp app = new OrganizeApp();

        Project project = new Project("FirstProject", ProjectType.WorkProject, LocalDateTime.parse("2022-08-20 12:00", formatter));

        WorkColleague workcolleague1 = new WorkColleague("George", 30, "male", "Cloud", "george@google.com", false);
        WorkColleague workcolleague2 = new WorkColleague("Alice", 31,"female", "QA", "alice@google.com", true);
        WorkColleague workcolleague3 = new WorkColleague("George2", 32,"male","Cloud", "george2@google.com", false);
        WorkColleague workcolleague4 = new WorkColleague("Alice2", 33,"female","Cloud", "alice2@google.com", true);

        project.addParticipant(workcolleague1);
        project.addParticipant(workcolleague2);
        project.addParticipant(workcolleague3);
        project.addParticipant(workcolleague4);

        Project project2 = new Project("SecondProject", ProjectType.PersonalAppointment, LocalDateTime.parse("2022-03-15 12:00", formatter));

        project.addParticipant(workcolleague1);
        project.addParticipant(workcolleague2);

        app.addProject(project);
        app.addProject(project2);

        assertEquals("SecondProject", app.getProjects().first().getName());
        assertEquals("FirstProject", app.getProjectsDescending().get(0).getName());
        assertEquals("FirstProject", app.getProjectsByMonth(Month.AUGUST).get(0).getName());
        assertEquals("SecondProject", app.getProjectByType(ProjectType.PersonalAppointment).get(0).getName());
        assertEquals("FirstProject", app.getProjectWithMostParticipants().getName());

    }
}
