package util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class String_Test {

    public static final char[] RESULT_EXPRESSION = {'t', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', 'n', ' ', 'e', 'x', 'a', 'm', 'p', 'l', 'e'};

    @Tag("java12")
    @Test
    public void givenAnInputText_whenIndenting_thenAddSpacesInTheBeginning() {
        String input = "\n****\n Hey there\n This is a sample message\n****";

        System.out.println(input);
        System.out.println(input.indent(1));
        System.out.println(input.indent(2));
        System.out.println(input.indent(-1));
    }

    @Test
    public void givenAString_whenContactChangeLowerCaseAndCreateAnArray_thenReturnAnArrayWithCharsAndOnlyLowerCaseChars() {
        String input = "Example";
        String changed = "This IS An ".concat(input);
        String lowerCase = changed.toLowerCase();
        char[] result = lowerCase.toCharArray();

        assertEquals(
                Boolean.TRUE,
                Arrays.equals(RESULT_EXPRESSION, result));
    }

    @Tag("java12")
    @Test
    public void givenAString_whenTransform_thenReturnAnArrayWithCharsAndOnlyLowerCaseChars() {
        String input = "Example";

        char[] result = input
                .transform(in -> "This IS An ".concat(in))
                .transform(String::toLowerCase)
                .transform(String::toCharArray);

        assertEquals(
                Boolean.TRUE,
                Arrays.equals(RESULT_EXPRESSION, result));
    }

    @Tag("java13")
    @Test
    public void giveAnStringWithEscapes_whenProcessIt_thenFixTheWrongEscapes() {
        String input = "Example \ta\\tb\\tc";

        assertEquals("Example \ta\\tb\\tc", input);
        assertEquals("Example \ta\tb\tc", input.translateEscapes());
    }

    @Tag("java13")
    @Test
    public void givenAStringWithFormatVariables_whenProcessIt_thenReturnFormattedString() {
        String input = "Hello %s!";

        assertEquals("Hello Java!", input.formatted("Java"));
    }

}
