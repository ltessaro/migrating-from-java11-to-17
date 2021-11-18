package records;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Records_Test {
    @Tag("java16")
    @Test
    public void givenAFlightRecord_whenBuildOne_thenGetTheValuesAndPrintItIsVersion() {
        //given //when
        final Flight flight = new Flight(12l, null, null, 9l);

        //then
        assertEquals(12l, flight.id());
        assertEquals(9l, flight.status());
        assertNull(flight.startDate());
        assertNull(flight.endDate());

        assertEquals("Flight[id=12, startDate=null, endDate=null, status=9]", flight.toString());
        assertEquals(Boolean.TRUE, flight.getClass().isRecord());
    }
}
