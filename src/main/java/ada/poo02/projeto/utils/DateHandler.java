package ada.poo02.projeto.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateHandler {
    private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    private DateHandler() {
    }

    public static LocalDateTime createLocalDateTime(String dateString, String timeString) {
        LocalDate date = LocalDate.parse(dateString, dateFormat);
        LocalTime time = LocalTime.parse(timeString);

        return LocalDateTime.of(date, time);
    }
    public static LocalDateTime createLocalDateTime(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

    public static LocalDateTime formatStringToDate(String stringToFormat) {
        return LocalDateTime.parse(stringToFormat, dateTimeFormat);
    }

    public static String formatDateToString(LocalDateTime dateToFormat) {
        return dateToFormat.format(dateTimeFormat);
    }
}
