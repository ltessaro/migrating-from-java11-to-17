package switchCommand;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Switch_Test {

    public static final String VALUE2_STRING = "VALUE2";

    @Test
    public void givenAnEnumValue2_whenExecuteSwitchWithCases_thenResultInNull() {
        //given
        SampleEnum input = SampleEnum.VALUE_2;

        //when
        String resultCase = SampleEnum.toStringUsingSwitchCase(input);

        //then
        assertEquals(null, resultCase);
    }

    @Test
    public void givenAnEnumValue2_whenExecuteSwitchWithCaseAndBreaks_thenResultInNull() {
        //given
        SampleEnum input = SampleEnum.VALUE_2;

        //when
        String resultCaseWithBreak = SampleEnum.toStringUsingSwitchCaseWithBreak(input);

        //then
        assertEquals(VALUE2_STRING, resultCaseWithBreak);
    }

    @Tag("java14")
    @Test
    public void givenAnEnumValue2_whenExecuteSwitchWithExpressions_thenResultInValue2() {
        //given
        SampleEnum input = SampleEnum.VALUE_2;

        //when
        String resultExpressions = SampleEnum.toStringUsingSwitchExpressions(input);

        //then
        assertEquals(VALUE2_STRING, resultExpressions);
    }
}
