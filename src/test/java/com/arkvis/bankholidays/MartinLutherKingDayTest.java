package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MartinLutherKingDayTest {

    @Test
    void should_returnTrue_when_checkingIfMLKDayIsAHoliday() {
        LocalDate mlk2022 = LocalDate.of(2022, 1, 17);
        LocalDate mlk2023 = LocalDate.of(2023, 1, 16);
        LocalDate mlk2024 = LocalDate.of(2024, 1, 15);
        LocalDate mlk2025 = LocalDate.of(2025, 1, 20);
        LocalDate mlk2026 = LocalDate.of(2026, 1, 19);

        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(mlk2022));
        assertTrue(bank.isHoliday(mlk2023));
        assertTrue(bank.isHoliday(mlk2024));
        assertTrue(bank.isHoliday(mlk2025));
        assertTrue(bank.isHoliday(mlk2026));
    }

    @Test
    void should_returnFalse_when_checkingIfDayAfterMLKIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2022, 1, 18);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }
}
