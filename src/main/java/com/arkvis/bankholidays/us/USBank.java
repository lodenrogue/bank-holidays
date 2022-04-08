package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Bank;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class USBank implements Bank {

    @Override
    public boolean isHoliday(LocalDate day) {
        return isNewYearsHoliday(day);
    }

    private boolean isNewYearsHoliday(LocalDate day) {
        if (isNewYearsDay(day)) return true;
        return isDayAfterNewYearsDay(day) && isAMonday(day);
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isDayAfterNewYearsDay(LocalDate day) {
        return isInJanuary(day) && day.getDayOfMonth() == 2;
    }

    private boolean isNewYearsDay(LocalDate day) {
        return isInJanuary(day) && day.getDayOfMonth() == 1;
    }

    private boolean isInJanuary(LocalDate day) {
        return day.getMonth().equals(Month.JANUARY);
    }
}
