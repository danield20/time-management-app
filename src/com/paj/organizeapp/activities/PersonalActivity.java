package com.paj.organizeapp.activities;

import com.paj.organizeapp.people.AbstractPeople;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class PersonalActivity extends AbstractActivity {
    String place;

    public PersonalActivity(int id, LocalDateTime startime, LocalDateTime endtime, String name, String place) {
        super(id, startime, endtime, name);
        this.place = place;
    }

    public String getPlace() {
        return  place;
    }

    @Override
    public String toString() {
        return "PersonalActivity{" +
                "place='" + place + '\'' +
                ", name='" + name + '\'' +
                ", startime=" + startime +
                ", endtime=" + endtime +
                '}';
    }
}
