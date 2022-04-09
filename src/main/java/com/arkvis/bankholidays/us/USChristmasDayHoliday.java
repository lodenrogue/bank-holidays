package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class USChristmasDayHoliday implements Holiday {

    private static final int CHRISTMAS_DAY = 25;

    @Override
    public boolean isHoliday(LocalDate day) {
        if (isChristmasDay(day)) return true;
        return isAMonday(day) && isDayAfterChristmasDay(day);
    }

    private boolean isChristmasDay(LocalDate day) {
        return isInDecember(day) && day.getDayOfMonth() == CHRISTMAS_DAY;
    }

    private boolean isDayAfterChristmasDay(LocalDate day) {
        return isInDecember(day) && day.getDayOfMonth() == CHRISTMAS_DAY + 1;
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isInDecember(LocalDate day) {
        return day.getMonth().equals(Month.DECEMBER);
    }
}
