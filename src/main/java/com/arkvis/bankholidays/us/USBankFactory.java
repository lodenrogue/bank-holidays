package com.arkvis.bankholidays.us;

import com.arkvis.bankholidays.Bank;
import com.arkvis.bankholidays.Holiday;

import java.util.List;

public class USBankFactory {

    private USBankFactory() {
    }

    public static Bank createBank() {
        List<Holiday> holidays = List.of(
                new USNewYearsDay(),
                new USMartinLutherKingDay(),
                new USPresidentsDay(),
                new USMemorialDay(),
                new USJuneteenth(),
                new USIndependenceDay(),
                new USLaborDay(),
                new USColumbusDay(),
                new USVeteransDay(),
                new USThanksgiving(),
                new USChristmas());

        return new Bank(holidays);
    }
}
