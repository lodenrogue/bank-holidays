package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USVeteransDayHoliday;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VeteransDayTest {

    @Test
    void should_returnTrue_when_checkingIfVeteransDayIsAHoliday() {
        LocalDate veteransDay = LocalDate.of(2022, 11, 11);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(veteransDay));
    }

    @Test
    void should_returnFalse_when_checkingIfTheDayAfterVeteransDayNotFallingOnAMondayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 11, 12);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnTrue_when_checkingIfTheDayAfterVeteransDayFallingOnAMondayIsAHoliday() {
        // 2018-11-12 falls on a Monday
        LocalDate dayAfter = LocalDate.of(2018, 11, 12);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        // 2022-04-11 falls on the 11th but is not in November
        LocalDate wrongMonth = LocalDate.of(2022, 4, 11);
        Bank bank = new Bank(List.of(new USVeteransDayHoliday()));
        assertFalse(bank.isHoliday(wrongMonth));
    }
}
