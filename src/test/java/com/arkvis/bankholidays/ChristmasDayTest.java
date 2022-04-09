package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USChristmas;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChristmasDayTest {

    @Test
    void should_returnTrue_when_checkingIfChristmasDayIsAHoliday() {
        LocalDate christmas = LocalDate.of(2022, 12, 25);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(christmas));
    }

    @Test
    void should_returnFalse_when_checkingIfTheDayAfterChristmasNotFallingOnAMondayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2023, 12, 26);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnTrue_when_checkingIfTheDayAfterChristmasFallingOnAMondayIsAHoliday() {
        // 2022-12-26 falls on a Monday
        LocalDate dayAfter = LocalDate.of(2022, 12, 26);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        // 2022-11-25 falls on the 25th but is not in December
        LocalDate wrongMonth = LocalDate.of(2022, 11, 25);
        Bank bank = new Bank(List.of(new USChristmas()));
        assertFalse(bank.isHoliday(wrongMonth));
    }
}
