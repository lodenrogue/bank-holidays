package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class USJuneteenth implements Holiday {
    private static final int JUNETEENTH_DAY = 19;

    @Override
    public boolean isHoliday(LocalDate day) {
        if (isJuneteenthDay(day)) return true;
        return isAMonday(day) && isDayAfterJuneteenthDay(day);
    }

    private boolean isJuneteenthDay(LocalDate day) {
        return isInJune(day) && day.getDayOfMonth() == JUNETEENTH_DAY;
    }

    private boolean isDayAfterJuneteenthDay(LocalDate day) {
        return isInJune(day) && day.getDayOfMonth() == JUNETEENTH_DAY + 1;
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isInJune(LocalDate day) {
        return day.getMonth().equals(Month.JUNE);
    }
}
