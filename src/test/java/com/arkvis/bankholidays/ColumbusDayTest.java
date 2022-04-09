package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USColumbusDay;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColumbusDayTest {

    @Test
    void should_returnTrue_when_checkingIfColumbusDayIsAHoliday() {
        LocalDate columbusDay2022 = LocalDate.of(2022, 10, 10);
        LocalDate columbusDay2023 = LocalDate.of(2023, 10, 9);
        LocalDate columbusDay2024 = LocalDate.of(2024, 10, 14);
        LocalDate columbusDay2025 = LocalDate.of(2025, 10, 13);
        LocalDate columbusDay2026 = LocalDate.of(2026, 10, 12);

        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(columbusDay2022));
        assertTrue(bank.isHoliday(columbusDay2023));
        assertTrue(bank.isHoliday(columbusDay2024));
        assertTrue(bank.isHoliday(columbusDay2025));
        assertTrue(bank.isHoliday(columbusDay2026));
    }

    @Test
    void should_returnFalse_when_checkingIfDayAfterColumbusDayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 10, 11);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        // 2022-12-12 is the second Monday of the month but is not in October
        LocalDate wrongMonth = LocalDate.of(2022, 12, 12);
        Bank bank = new Bank(List.of(new USColumbusDay()));
        assertFalse(bank.isHoliday(wrongMonth));
    }
}
