package framework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SetDate {
    public static final String yyyy_mm_dd = "yyyy-MM-dd";

    public static String date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(yyyy_mm_dd);
        return LocalDate.now().plusDays(1).format(formatter);
    }
}
