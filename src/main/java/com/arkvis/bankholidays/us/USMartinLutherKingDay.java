package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class USMartinLutherKingDay implements Holiday {

    @Override
    public boolean isHoliday(LocalDate day) {
        return isInJanuary(day)
                && isAMonday(day)
                && isThirdWeek(day);
    }

    private boolean isThirdWeek(LocalDate day) {
        return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 3;
    }

    private boolean isInJanuary(LocalDate day) {
        return day.getMonth().equals(Month.JANUARY);
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }
}
