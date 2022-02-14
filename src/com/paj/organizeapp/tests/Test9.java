package com.paj.organizeapp.tests;

import com.paj.organizeapp.activities.Spending;
import com.paj.organizeapp.activities.WorkActivity;
import com.paj.organizeapp.exceptions.ActivityOverlayException;
import com.paj.organizeapp.exceptions.DateNotCorrectException;
import com.paj.organizeapp.exceptions.InsufficientFundsException;
import com.paj.organizeapp.main.OrganizeApp;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;


public class Test9 {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test(expected = InsufficientFundsException.class)
    public void testInsufficientFundsException() throws Exception {
        OrganizeApp app = new OrganizeApp();

        Spending spending = new Spending(200, "Cumparaturi");

        app.addFinancial(spending);
    }

    @Test(expected = DateNotCorrectException.class)
    public void testDateNotCorrect() throws Exception {
        OrganizeApp app = new OrganizeApp();

        WorkActivity wrk1 = new WorkActivity(1,
                LocalDateTime.parse("2022-04-16 12:00", formatter),
                LocalDateTime.parse("2022-03-20 12:00", formatter),
                "WorkActivity",
                "Google",
                "400",
                "Bucharest"
        );

        app.addActivity(wrk1);
    }

    @Test(expected = ActivityOverlayException.class)
    public void testActivityOverlay() throws Exception {
        OrganizeApp app = new OrganizeApp();

        WorkActivity wrk1 = new WorkActivity(1,
                LocalDateTime.parse("2022-02-10 12:00", formatter),
                LocalDateTime.parse("2022-03-10 12:00", formatter),
                "WorkActivity1",
                "Google",
                "400",
                "Bucharest"
        );

        WorkActivity wrk2 = new WorkActivity(1,
                LocalDateTime.parse("2022-02-20 12:00", formatter),
                LocalDateTime.parse("2022-03-08 12:00", formatter),
                "WorkActivity2",
                "Google",
                "400",
                "Bucharest"
        );

        app.addActivity(wrk1);
        app.addActivity(wrk2);
    }
}
