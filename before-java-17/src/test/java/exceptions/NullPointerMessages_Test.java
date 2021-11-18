package exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NullPointerMessages_Test {
    @Test
    public void givenANullPointerSituation_whenExecute_thenThrowNullPointerWithSimpleMessage() {
        //given
        Map<String, String> map = new HashMap<>();
        Executable whenExecutable = () -> map.putAll(null);

        //when
        NullPointerException npe = assertThrows(NullPointerException.class, whenExecutable);

        //then
        assertNull(npe.getMessage());
        npe.printStackTrace();
    }
}
