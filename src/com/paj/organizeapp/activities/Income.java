package com.paj.organizeapp.activities;

import java.time.LocalDateTime;

public class Income extends FinancialOperation {
    public Income(int amount, String description) {
        super(amount, description);
    }

    @Override
    public String toString() {
        return "Income{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
