package formatting;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayPeriod_Test {
    public static final String FORMAT_PATTERN = "B";

    final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(FORMAT_PATTERN);

    @Tag("java16")
    @Test
    public void givenAnHour_whenFormatting_thenShowTheDayPeriod() {
        assertEquals("in the morning", DATE_FORMAT.format(LocalTime.of(7, 11)));
        assertEquals("noon", DATE_FORMAT.format(LocalTime.of(12, 0)));
        assertEquals("in the afternoon", DATE_FORMAT.format(LocalTime.of(14, 22)));
        assertEquals("in the evening", DATE_FORMAT.format(LocalTime.of(20, 37)));
        assertEquals("at night", DATE_FORMAT.format(LocalTime.of(23, 9)));
        assertEquals("midnight", DATE_FORMAT.format(LocalTime.of(0, 0)));
        assertEquals("at night", DATE_FORMAT.format(LocalTime.of(3, 0)));
    }
}
