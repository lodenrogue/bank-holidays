## Bank Holidays

Java library for determining whether a given day is a bank holiday

### Usage

``` java
LocalDate newYears = LocalDate.of(2022, 1, 1);
Bank bank = USBankFactory.createBank();
boolean isHoliday = bank.isHoliday(newYears);
```

### Using an Existing Bank

``` java
// This bank comes packaged with the Federal Reserve Bank holidays 
Bank bank = USBankFactory.createBank();
```

### Creating a Holiday

The Holiday interface can be used to create a new Holiday

``` java
class NewHoliday implements Holiday {
    
    @Override
    public boolean isHoliday(LocalDate day) {
        // Your logic for determining if 
        // the given day is a holiday goes here
        // ...
    }
}
```

### Creating a New Bank

``` java
List<Holiday> holidays = List.of(aHoliday, anotherHoliday);
Bank bank = new Bank(holidays);
```

### Existing Holidays

- USChristmas
- USColumbusDay
- USIndependenceDay
- USJuneteenth
- USLaborDay
- USMartinLutherKingDay
- USMemorialDay
- USNewYearsDay
- USPresidentsDay
- USThanksgiving
- USVeteransDay

### Contributing
Please feel free to submit a pull request with new holidays and banks
