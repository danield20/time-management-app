package com.paj.organizeapp.activities;

import java.time.LocalDateTime;

public interface Activity {
    public int getId();
    public LocalDateTime getStartTime();
    public LocalDateTime getEndTime();
    public String getName();
}
