package util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileMismatch_Test {

    public static final String FIRST_FILE_CONTENT = "Just added something to the file!";
    public static final String SECOND_FILE_CONTENT = "Just added something to this file.";

    @Tag("java12")
    @Test
    public void givenIdenticalFile_whenComparing_returnTheyAreIdentical() throws IOException {
        //given
        Path firstFile = Files.createTempFile("firstFileForTest", ".txt");
        Path secondFile = Files.createTempFile("secondFileForTest", ".txt");

        Files.writeString(firstFile, FIRST_FILE_CONTENT);
        Files.writeString(secondFile, FIRST_FILE_CONTENT);

        //when
        long mismatchResult = Files.mismatch(firstFile, secondFile);

        //then
        assertEquals(-1, mismatchResult);

        firstFile.toFile().deleteOnExit();
        secondFile.toFile().deleteOnExit();
    }

    @Tag("java12")
    @Test
    public void givenNonIdenticalFile_whenComparing_returnWhereTheyAreDifferent() throws IOException {
        //given
        Path firstFile = Files.createTempFile("firstFileForTest", ".txt");
        Path secondFile = Files.createTempFile("secondFileForTest", ".txt");

        Files.writeString(firstFile, FIRST_FILE_CONTENT);
        Files.writeString(secondFile, SECOND_FILE_CONTENT);

        //when
        long mismatchFirstAndSecond = Files.mismatch(firstFile, secondFile);

        //then
        assertEquals(26, mismatchFirstAndSecond);

        assertEquals("e file!", FIRST_FILE_CONTENT.substring((int)mismatchFirstAndSecond));
        assertEquals("is file.", SECOND_FILE_CONTENT.substring((int)mismatchFirstAndSecond));

        firstFile.toFile().deleteOnExit();
        secondFile.toFile().deleteOnExit();
    }

}
