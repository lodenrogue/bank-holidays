package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class USVeteransDayHoliday implements Holiday {

    private static final int VETERANS_DAY = 11;

    @Override
    public boolean isHoliday(LocalDate day) {
        if (isVeteransDay(day)) return true;
        return isAMonday(day) && isDayAfterVeteransDay(day);
    }

    private boolean isVeteransDay(LocalDate day) {
        return isInNovember(day) && day.getDayOfMonth() == VETERANS_DAY;
    }

    private boolean isDayAfterVeteransDay(LocalDate day) {
        return isInNovember(day) && day.getDayOfMonth() == VETERANS_DAY + 1;
    }

    private boolean isAMonday(LocalDate day) {
        return day.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isInNovember(LocalDate day) {
        return day.getMonth().equals(Month.NOVEMBER);
    }
}
