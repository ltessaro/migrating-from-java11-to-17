package switchCommand;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchAndYield_Test {
    @Tag("java14")
    @Test
    public void givenASwitchExpressions_whenNeededMoreThanOneLine_thenUseYield() {
        final String input = "N";

        String result = switch(input) {
            case "M" -> "It is an M";
            case "N" -> {
                System.out.println("When it requires more than one line");
                yield "It is an N";
            }
            default -> "No letter found!";
        };

        assertEquals("It is an N", result);
    }
}
