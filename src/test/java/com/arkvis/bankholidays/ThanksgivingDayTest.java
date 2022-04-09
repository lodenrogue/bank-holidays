package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USThanksgiving;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThanksgivingDayTest {

    @Test
    void should_returnTrue_when_checkingIfThanksgivingDayIsAHoliday() {
        LocalDate thanksgiving2022 = LocalDate.of(2022, 11, 24);
        LocalDate thanksgiving2023 = LocalDate.of(2023, 11, 23);
        LocalDate thanksgiving2024 = LocalDate.of(2024, 11, 28);
        LocalDate thanksgiving2025 = LocalDate.of(2025, 11, 27);
        LocalDate thanksgiving2026 = LocalDate.of(2026, 11, 26);

        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(thanksgiving2022));
        assertTrue(bank.isHoliday(thanksgiving2023));
        assertTrue(bank.isHoliday(thanksgiving2024));
        assertTrue(bank.isHoliday(thanksgiving2025));
        assertTrue(bank.isHoliday(thanksgiving2026));
    }

    @Test
    void should_returnFalse_when_checkingIfTheDayAfterThanksgivingDayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 11, 25);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        //2022-08-25 is the fourth Thursday of the month but is not in November
        LocalDate dayAfter = LocalDate.of(2022, 8, 25);
        Bank bank = new Bank(List.of(new USThanksgiving()));
        assertFalse(bank.isHoliday(dayAfter));
    }
}
