package com.paj.organizeapp.tests;
import static org.junit.Assert.assertEquals;

import com.paj.organizeapp.activities.Income;
import com.paj.organizeapp.activities.Goal;
import com.paj.organizeapp.activities.Spending;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test5 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testFinancialOperations() {
        Income income = new Income(1000, "Bursa");
        Spending spending = new Spending(150, "Cumparaturi");

        assertEquals((long)1000, (long)income.getAmount());
        assertEquals("Bursa", income.getDescription());

        assertEquals((long)150, (long)spending.getAmount());
        assertEquals("Cumparaturi", spending.getDescription());

        income.setDate(LocalDateTime.parse("2022-10-10 12:00", formatter));
        assertEquals("2022-10-10T12:00", income.getDate().toString());

        assertEquals("Income{amount=1000, description=\'Bursa\'}", income.toString());
        assertEquals("Spending{amount=150, description=\'Cumparaturi\'}", spending.toString());
    }


    @Test
    public void testGoal() {
        Goal milestone = new Goal("Weight Milestone", "Losing first 10kg", false);

        assertEquals("Weight Milestone", milestone.getName());
        assertEquals("Losing first 10kg", milestone.getObjective_description());
        assertEquals(false, milestone.isAchieved());

        milestone.setAchieved();

        assertEquals(true, milestone.isAchieved());

    }
}
