package text;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TextBlocks_Test {

    private String EXPECTED_RESULT;

    @BeforeAll
    public void setup() throws Exception {
        List<String> lines = Files.readAllLines(Path.of(getClass().getClassLoader().getResource("text-block.txt").toURI()));
        EXPECTED_RESULT = lines.stream().reduce((a, b) -> a.concat("\n").concat(b)).get();
    }

    @Test
    public void givenAMultiLineStringWithJava11Style_whenCompareToTheSameMultiLineStringFromFile_thenItIsEquals() {
        //given //when
        String text = "{\n" +
                "  \"language\": \"Java\",\n" +
                "  \"version\": 11,\n" +
                "  \"date\": \"2021-11-17\"\n" +
                "}\n";

        //then
        assertEquals(EXPECTED_RESULT, text);
    }

    @Tag("java15")
    @Test
    public void givenAMultiLineStringWithJava17Style_whenCompareToTheSameMultiLineStringFromFile_thenItIsEquals() {
        //given //when
        String text = """
                {
                  "language": "Java",
                  "version": 11,
                  "date": "2021-11-17"
                }
                """;

        //then
        assertEquals(EXPECTED_RESULT, text);
    }
}
