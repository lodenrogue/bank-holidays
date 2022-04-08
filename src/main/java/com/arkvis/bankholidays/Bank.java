package com.arkvis.bankholidays;

import java.time.LocalDate;
import java.util.List;

public class Bank {

    private final List<Holiday> holidays;

    public Bank(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public boolean isHoliday(LocalDate day) {
        return holidays.stream().anyMatch(holiday -> holiday.isHoliday(day));
    }
}
