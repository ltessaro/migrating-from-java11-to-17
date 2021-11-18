package records;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecordsWithCompactConstructor_Test {
    @Tag("java16")
    @Test
    public void givenAFlightRecordWithCompactConstructor_whenBuild_thenApplyTheCompactConstructor() {
        //given //when
        final FlightWithCompactConstructor flightWithCompactConstructor = new FlightWithCompactConstructor(12l, null, null, 9l);

        //then
        assertEquals(12l, flightWithCompactConstructor.id());
        assertEquals(9l, flightWithCompactConstructor.status());
        assertNull(flightWithCompactConstructor.startDate());
        assertNull(flightWithCompactConstructor.endDate());

        assertEquals("FlightWithCompactConstructor[id=12, startDate=null, endDate=null, status=9]", flightWithCompactConstructor.toString());
    }

    @Tag("java14")
    @Test
    public void givenAFlightRecordWithCompactConstructor_whenBuild_thenApplyTheCompactConstructorAndThrowsException() {
        //given
        Executable whenExecutable = () -> new FlightWithCompactConstructor(
                910l,
                ZonedDateTime.now(),
                ZonedDateTime.now().minusWeeks(1l),
                12l);

        //when
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, whenExecutable);

        //then
        assertEquals("startDate must be before endDate", iae.getMessage());
    }
}
