package com.paj.organizeapp.activities;

import java.time.LocalDateTime;

public class Spending extends FinancialOperation {
    public Spending(int amount, String description) {
        super(amount, description);
    }

    @Override
    public String toString() {
        return "Spending{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
