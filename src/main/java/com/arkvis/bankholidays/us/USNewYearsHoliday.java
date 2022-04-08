package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class USNewYearsHoliday implements Holiday {

    @Override
    public boolean isHoliday(LocalDate day) {
        if (isNewYearsDay(day)) return true;
        return isDayAfterNewYearsDay(day) && isAMonday(day);
    }

    private boolean isNewYearsDay(LocalDate day) {
        return isInJanuary(day) && day.getDayOfMonth() == 1;
    }

    private boolean isDayAfterNewYearsDay(LocalDate day) {
        return isInJanuary(day) && day.getDayOfMonth() == 2;
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isInJanuary(LocalDate day) {
        return day.getMonth().equals(Month.JANUARY);
    }
}
