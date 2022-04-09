package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USIndependenceDay;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IndependenceDayTest {

    @Test
    void should_returnTrue_when_checkingIfIndependenceDayIsAHoliday() {
        LocalDate independenceDay = LocalDate.of(2022, 7, 4);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(independenceDay));
    }

    @Test
    void should_returnFalse_when_checkingIfTheDayAfterIndependenceDayNotFallingOnAMondayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 7, 5);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnTrue_when_checkingIfTheDayAfterIndependenceDayFallingOnAMondayIsAHoliday() {
        // 2021-07-05 falls on a Monday
        LocalDate dayAfter = LocalDate.of(2021, 7, 5);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        // 2022-11-04 is the 4th day of the month but is not July
        LocalDate wrongMonth = LocalDate.of(2022, 11, 4);
        Bank bank = new Bank(List.of(new USIndependenceDay()));
        assertFalse(bank.isHoliday(wrongMonth));
    }
}
