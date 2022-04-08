package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class USMemorialDayHoliday implements Holiday {

    private static final int JUNE_MONTH_NUMBER = 6;

    @Override
    public boolean isHoliday(LocalDate day) {
        LocalDate juneFirst = LocalDate.of(day.getYear(), JUNE_MONTH_NUMBER, 1);
        LocalDate lastMondayOfMay = juneFirst.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        return day.equals(lastMondayOfMay);
    }
}
