package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class USLaborDay implements Holiday {

    @Override
    public boolean isHoliday(LocalDate day) {
        return isInSeptember(day)
                && isAMonday(day)
                && isFirstWeek(day);
    }

    private boolean isInSeptember(LocalDate day) {
        return day.getMonth().equals(Month.SEPTEMBER);
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isFirstWeek(LocalDate day) {
        return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 1;
    }
}
