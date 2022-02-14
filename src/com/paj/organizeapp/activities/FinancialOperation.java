package com.paj.organizeapp.activities;

import java.time.LocalDateTime;

public abstract class FinancialOperation {
    int amount;
    String description;
    LocalDateTime date;

    public FinancialOperation(int amount, String description) {
        this.amount = amount;
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public Integer getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }


}
