package exceptions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NullPointerMessages_Test {

    @Tag("java14")
    @Test
    public void givenANullPointerSituation_whenExecute_thenThrowNullPointerWithACompleteMessage() {
        //given
        Map<String, String> map = new HashMap<>();
        Executable whenExecutable = () -> map.putAll(null);

        //when
        NullPointerException npe = assertThrows(NullPointerException.class, whenExecutable);

        //then
        assertEquals("Cannot invoke \"java.util.Map.size()\" because \"m\" is null", npe.getMessage());
        npe.printStackTrace();
    }
}
