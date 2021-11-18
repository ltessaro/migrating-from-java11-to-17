package formatting;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Number_Test {
    public static final int TWO_K = 2000;
    public static final int THREE_HUNDRED_K = 300000;
    public static final int FIFTY_MILLION = 50000000;

    final NumberFormat COMPACT_FORMAT_SHORT = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
    final NumberFormat COMPACT_FORMAT_LONG = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
    final NumberFormat NORMAL_FORMAT_SHORT = NumberFormat.getNumberInstance(Locale.ENGLISH);

    final NumberFormat IN_COMPACT_FORMAT_SHORT = NumberFormat.getCompactNumberInstance(new Locale("en", "IN"), NumberFormat.Style.SHORT);

    @Tag("java12")
    @Test
    public void givenAn2000_whenFormat_thenRepresentsAsString() {
        assertEquals("2,000", NORMAL_FORMAT_SHORT.format(TWO_K));
        assertEquals("2K", COMPACT_FORMAT_SHORT.format(TWO_K));
        assertEquals("2 thousand", COMPACT_FORMAT_LONG.format(TWO_K));

        assertEquals("2T", IN_COMPACT_FORMAT_SHORT.format(TWO_K));
    }

    @Tag("java12")
    @Test
    public void givenAn300K_whenFormat_thenRepresentsAsString() {
        assertEquals("300,000", NORMAL_FORMAT_SHORT.format(THREE_HUNDRED_K));
        assertEquals("300K", COMPACT_FORMAT_SHORT.format(THREE_HUNDRED_K));
        assertEquals("300 thousand", COMPACT_FORMAT_LONG.format(THREE_HUNDRED_K));

        assertEquals("3L", IN_COMPACT_FORMAT_SHORT.format(THREE_HUNDRED_K));
    }

    @Tag("java12")
    @Test
    public void givenAn50M_whenFormat_thenRepresentsAsString() {
        assertEquals("50,000,000", NORMAL_FORMAT_SHORT.format(FIFTY_MILLION));
        assertEquals("50M", COMPACT_FORMAT_SHORT.format(FIFTY_MILLION));
        assertEquals("50 million", COMPACT_FORMAT_LONG.format(FIFTY_MILLION));

        assertEquals("5Cr", IN_COMPACT_FORMAT_SHORT.format(FIFTY_MILLION));
    }
}
