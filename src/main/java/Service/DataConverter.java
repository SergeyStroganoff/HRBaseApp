package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataConverter {

    static final String PATTERN = "dd.MM.yyyy";

    public static LocalDate getDateFromString(String stringDate) {
        LocalDate date;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATTERN);
        date = LocalDate.parse(stringDate, dtf);
        return date;
        //  01/05/16
    }

    public static String dataToString(LocalDate date) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATTERN);
        return dtf.format(date);
    }
}
