package com.arkvis.bankholidays;

import com.arkvis.bankholidays.us.USBankFactory;
import com.arkvis.bankholidays.us.USMemorialDayHoliday;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MemorialDayTest {

    @Test
    void should_returnTrue_when_checkingIfMemorialDayIsAHoliday() {
        LocalDate memorial2022 = LocalDate.of(2022, 5, 30);
        LocalDate memorial2023 = LocalDate.of(2023, 5, 29);
        LocalDate memorial2024 = LocalDate.of(2024, 5, 27);
        LocalDate memorial2025 = LocalDate.of(2025, 5, 26);
        LocalDate memorial2026 = LocalDate.of(2026, 5, 25);

        Bank bank = USBankFactory.createBank();
        assertTrue(bank.isHoliday(memorial2022));
        assertTrue(bank.isHoliday(memorial2023));
        assertTrue(bank.isHoliday(memorial2024));
        assertTrue(bank.isHoliday(memorial2025));
        assertTrue(bank.isHoliday(memorial2026));
    }

    @Test
    void should_returnFalse_when_checkingIfDayAfterMemorialDayIsAHoliday() {
        LocalDate dayAfter = LocalDate.of(2023, 5, 30);
        Bank bank = USBankFactory.createBank();
        assertFalse(bank.isHoliday(dayAfter));
    }

    @Test
    void should_returnFalse_when_checkingIfDayInWrongMonthIsAHoliday() {
        //2022-08-29 is the last Monday of the month but is not in May
        LocalDate dayAfter = LocalDate.of(2022, 8, 29);
        Bank bank = new Bank(List.of(new USMemorialDayHoliday()));
        assertFalse(bank.isHoliday(dayAfter));
    }
}
