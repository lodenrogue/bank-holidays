package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USPresidentsDayHoliday;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PresidentsDayTest {

    @Test
    void should_returnTrue_when_checkingIfPresidentsDayIsAHoliday() {
        LocalDate presDay2022 = LocalDate.of(2022, 2, 21);
        LocalDate presDay2023 = LocalDate.of(2023, 2, 20);
        LocalDate presDay2024 = LocalDate.of(2024, 2, 19);
        LocalDate presDay2025 = LocalDate.of(2025, 2, 17);
        LocalDate presDay2026 = LocalDate.of(2026, 2, 16);

        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(presDay2022));
        assertTrue(bank.isHoliday(presDay2023));
        assertTrue(bank.isHoliday(presDay2024));
        assertTrue(bank.isHoliday(presDay2025));
        assertTrue(bank.isHoliday(presDay2026));
    }

    @Test
    void should_returnFalse_when_checkingIfTheDayAfterPresidentsDayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 2, 22);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInTheWrongMonthIsAHoliday() {
        // 2022-05-16 is the third Monday of the month but is not in February
        LocalDate wrongMonth = LocalDate.of(2022, 5, 16);
        Bank bank = new Bank(List.of(new USPresidentsDayHoliday()));
        assertFalse(bank.isHoliday(wrongMonth));
    }
}
