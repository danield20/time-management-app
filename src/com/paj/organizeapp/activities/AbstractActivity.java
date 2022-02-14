package com.paj.organizeapp.activities;

import com.paj.organizeapp.email.Email;
import com.paj.organizeapp.email.EmailService;
import com.paj.organizeapp.people.AbstractPeople;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

@SuppressWarnings("Duplicates")
public abstract class AbstractActivity extends Social implements Activity, Serializable {
    private int id;
    String name;
    LocalDateTime startime;
    LocalDateTime endtime;

    public AbstractActivity(int id, LocalDateTime startime, LocalDateTime endtime, String name) {
        super();
        this.id = id;
        this.startime = startime;
        this.endtime = endtime;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LocalDateTime getStartTime() {
        return startime;
    }

    @Override
    public LocalDateTime getEndTime() {
        return endtime;
    }

    @Override
    public String getName() {
        return name;
    }
}
