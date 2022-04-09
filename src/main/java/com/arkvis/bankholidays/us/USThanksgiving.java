package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class USThanksgiving implements Holiday {

    @Override
    public boolean isHoliday(LocalDate day) {
        return isInNovember(day)
                && isAThursday(day)
                && isFourthWeek(day);
    }

    private boolean isInNovember(LocalDate day) {
        return day.getMonth().equals(Month.NOVEMBER);
    }

    private boolean isAThursday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.THURSDAY);
    }

    private boolean isFourthWeek(LocalDate day) {
        return day.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 4;
    }
}
