package com.paj.organizeapp.activities;

import java.time.LocalDateTime;

public class WorkActivity extends AbstractActivity {
    String company;
    String meeting_room;
    String office;

    public WorkActivity(int id, LocalDateTime startime, LocalDateTime endtime, String name,
                        String company, String meeting_room, String office) {
        super(id, startime, endtime, name);
        this.company = company;
        this.meeting_room = meeting_room;
        this.office = office;
    }

    public String getCompany() {
        return company;
    }

    public String getMeeting_room() {
        return meeting_room;
    }

    public String getOffice() {
        return office;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setMeeting_room(String meeting_room) {
        this.meeting_room = meeting_room;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "WorkActivity{" +
                "company='" + company + '\'' +
                ", meeting_room='" + meeting_room + '\'' +
                ", office='" + office + '\'' +
                ", name='" + name + '\'' +
                ", startime=" + startime +
                ", endtime=" + endtime +
                '}';
    }
}
