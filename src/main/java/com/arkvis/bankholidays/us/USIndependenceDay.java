package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class USIndependenceDay implements Holiday {

    private static final int INDEPENDENCE_DAY = 4;

    @Override
    public boolean isHoliday(LocalDate day) {
        if (isIndependenceDay(day)) return true;
        return isAMonday(day) && isDayAfterIndependenceDay(day);
    }

    private boolean isIndependenceDay(LocalDate day) {
        return isInJuly(day) && day.getDayOfMonth() == INDEPENDENCE_DAY;
    }

    private boolean isDayAfterIndependenceDay(LocalDate day) {
        return isInJuly(day) && day.getDayOfMonth() == INDEPENDENCE_DAY + 1;
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isInJuly(LocalDate day) {
        return day.getMonth().equals(Month.JULY);
    }
}
