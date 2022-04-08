package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class USColumbusDayHoliday implements Holiday {

    @Override
    public boolean isHoliday(LocalDate day) {
        return isInOctober(day)
                && isAMonday(day)
                && isSecondWeek(day);
    }

    private boolean isInOctober(LocalDate day) {
        return day.getMonth().equals(Month.OCTOBER);
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isSecondWeek(LocalDate day) {
        return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 2;
    }
}
