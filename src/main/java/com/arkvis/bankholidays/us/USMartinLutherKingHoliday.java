package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class USMartinLutherKingHoliday implements Holiday {

    @Override
    public boolean isHoliday(LocalDate day) {
        return isAMonday(day) && day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 3;
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }
}
