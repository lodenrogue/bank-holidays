package com.arkvis.bankholidays;

import java.time.LocalDate;

public interface Holiday {

    boolean isHoliday(LocalDate day);
}
