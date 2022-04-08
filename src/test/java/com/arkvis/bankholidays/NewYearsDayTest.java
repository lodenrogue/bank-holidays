package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewYearsDayTest {

    @Test
    void should_returnTrue_when_checkingIfNewYearsDayIsAHoliday() {
        LocalDate newYearsDay = LocalDate.of(2022, 1, 1);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(newYearsDay));
    }

    @Test
    void should_returnFalse_when_checkingIfTheDayAfterNewYearsNotFallingOnAMondayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 1, 2);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnTrue_when_checkingIfTheDayAfterNewYearsFallingOnAMondayIsAHoliday() {
        // 2017-01-02 falls on a Monday
        LocalDate dayAfter = LocalDate.of(2017, 1, 2);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(dayAfter));
    }
}
