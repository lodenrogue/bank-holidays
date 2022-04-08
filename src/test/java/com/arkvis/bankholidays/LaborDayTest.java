package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USLaborDayHoliday;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LaborDayTest {

    @Test
    void should_returnTrue_when_checkingIfLaborDayIsAHoliday() {
        LocalDate laborDay2022 = LocalDate.of(2022, 9, 5);
        LocalDate laborDay2023 = LocalDate.of(2023, 9, 4);
        LocalDate laborDay2024 = LocalDate.of(2024, 9, 2);
        LocalDate laborDay2025 = LocalDate.of(2025, 9, 1);
        LocalDate laborDay2026 = LocalDate.of(2026, 9, 7);

        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(laborDay2022));
        assertTrue(bank.isHoliday(laborDay2023));
        assertTrue(bank.isHoliday(laborDay2024));
        assertTrue(bank.isHoliday(laborDay2025));
        assertTrue(bank.isHoliday(laborDay2026));
    }

    @Test
    void should_returnFalse_when_checkingIfDayAfterLaborDayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 9, 6);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        // 2022-10-03 is the first Monday of the month but is not in September
        LocalDate wrongMonth = LocalDate.of(2022, 10, 3);
        Bank bank = new Bank(List.of(new USLaborDayHoliday()));
        assertFalse(bank.isHoliday(wrongMonth));
    }
}
