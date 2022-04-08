package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class USPresidentsDayHoliday implements Holiday {

    @Override
    public boolean isHoliday(LocalDate day) {
        return isInFebruary(day)
                && isAMonday(day)
                && day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 3;
    }

    private boolean isInFebruary(LocalDate day) {
        return day.getMonth().equals(Month.FEBRUARY);
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }
}
