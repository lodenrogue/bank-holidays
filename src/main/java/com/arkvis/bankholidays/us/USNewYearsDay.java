package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class USNewYearsDay implements Holiday {

    private static final int NEW_YEARS_DAY = 1;

    @Override
    public boolean isHoliday(LocalDate day) {
        if (isNewYearsDay(day)) return true;
        return isAMonday(day) && isDayAfterNewYearsDay(day);
    }

    private boolean isNewYearsDay(LocalDate day) {
        return isInJanuary(day) && day.getDayOfMonth() == NEW_YEARS_DAY;
    }

    private boolean isDayAfterNewYearsDay(LocalDate day) {
        return isInJanuary(day) && day.getDayOfMonth() == NEW_YEARS_DAY + 1;
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isInJanuary(LocalDate day) {
        return day.getMonth().equals(Month.JANUARY);
    }
}
