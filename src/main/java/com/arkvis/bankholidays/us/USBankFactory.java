package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Bank;
import com.arkvis.bankholidays.Holiday;

import java.util.List;

public class USBankFactory {

    private USBankFactory() {
    }

    public static Bank createBank() {
        List<Holiday> holidays = List.of(
                new USNewYearsDayHoliday(),
                new USMartinLutherKingDayHoliday(),
                new USPresidentsDayHoliday(),
                new USMemorialDayHoliday(),
                new USJuneteenthDayHoliday());

        return new Bank(holidays);
    }
}
