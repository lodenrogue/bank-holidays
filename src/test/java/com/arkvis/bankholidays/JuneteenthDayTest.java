package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USJuneteenth;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JuneteenthDayTest {

    @Test
    void should_returnTrue_when_checkingIfJuneteenthIsAHoliday() {
        LocalDate juneteenth = LocalDate.of(2023, 6, 19);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(juneteenth));
    }

    @Test
    void should_returnFalse_when_checkingIfTheDayAfterJuneteenthNotFallingOnAMondayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2023, 6, 20);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnTrue_when_checkingIfTheDayAfterJuneteenthFallingOnAMondayIsAHoliday() {
        // 2022-06-20 falls on a Monday
        LocalDate dayAfter = LocalDate.of(2022, 6, 20);
        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        // 2022-09-19 falls on the 19th but is not in June
        LocalDate wrongMonth = LocalDate.of(2022, 9, 19);
        Bank bank = new Bank(List.of(new USJuneteenth()));
        assertFalse(bank.isHoliday(wrongMonth));
    }
}
