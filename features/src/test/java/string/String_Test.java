package string;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class String_Test {

    public static final char[] RESULT_EXPRESSION = {'t', 'h', 'i', 's', 'i', 's', 'a', 'n', 'e', 'x', 'a', 'm', 'p', 'l', 'e'};

    private final Function<String, String> removeSpaceFunction = s -> s.replaceAll(" ", "");

    @Tag("java12")
    @Test
    public void givenAnInputText_whenIndenting_thenAddSpacesInTheBeginning() {
        String input = "\n****\n Hey there\n This is a sample message\n****";

        System.out.println("\nORIGINAL");
        System.out.println(input);
        System.out.println("\n\nINDENT 1");
        System.out.println(input.indent(1));
        System.out.println("\n\nINDENT 2");
        System.out.println(input.indent(2));
        System.out.println("\n\nINDENT -1");
        System.out.println(input.indent(-1));
    }

    @Test
    public void givenAString_whenContactChangeLowerCaseAndCreateAnArray_thenReturnAnArrayWithCharsAndOnlyLowerCaseChars() {
        String input = "Example";
        String changed = "This IS An ".concat(input);
        String lowerCase = changed.toLowerCase();
        String removedSpace = removeSpaceFunction.apply(lowerCase);
        char[] result = removedSpace.toCharArray();

        assertEquals(
                Boolean.TRUE,
                Arrays.equals(RESULT_EXPRESSION, result));

        char[] secondResult = removeSpaceFunction.apply("This IS An ".concat(input).toLowerCase()).toCharArray();

        assertEquals(
                Boolean.TRUE,
                Arrays.equals(RESULT_EXPRESSION, secondResult));

    }

    @Tag("java12")
    @Test
    public void givenAString_whenTransform_thenReturnAnArrayWithCharsAndOnlyLowerCaseChars() {
        String input = "Example";

        char[] result = input
                .transform(in -> "This IS An ".concat(in))
                .transform(String::toLowerCase)
                .transform(removeSpaceFunction)
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

        assertEquals("Hello Java!", input.formatted("Java")); //String.format("", ...args)
    }

}
