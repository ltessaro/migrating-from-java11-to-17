package pattern;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import records.Flight;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternMatchingForInstanceOf_Test {

    public static final long FLIGHT_ID = 987L;

    @Test
    public void givenAnObject_whenCasting_thenCallTheMethodOnTheSubclass() {
        Object object = new Flight(FLIGHT_ID, null, null, 12L);
        if (object instanceof Flight) {
            Flight flight = (Flight) object;
            assertEquals(FLIGHT_ID, flight.id());
        }
    }

    @Tag("java16")
    @Test
    public void givenAnObject_whenCasting_thenCallTheMethodOnTheSubclassAfterJava16() {
        Object object = new Flight(FLIGHT_ID, null, null, 12L);
        if (object instanceof Flight flight) {
            assertEquals(FLIGHT_ID, flight.id());
            assertEquals(Boolean.TRUE, hasSameId(object, FLIGHT_ID));
        }

        Object array = new String[]{ "one", "two" };

        if (array instanceof String[] sa && sa.length >= 2) {
            assertEquals("one", sa[0]);
            assertEquals("two", sa[1]);
        }
    }

    public boolean hasSameId(Object o, Long id) {
        return (o instanceof Flight f) && f.id().equals(id);
    }

    @Tag("java17-preview-and-java18")
    @Test
    public void futureEnhancements() {
        Object object = new Flight(FLIGHT_ID, null, null, 12l);
        /*
        17 - preview
        Long l = switch (object) {
            case Flight f -> f.id();
            default -> 0;
        }

        JEP 405 - 18
        if (object instanceof Flight(Long id, ZonedDateTime z1, ZonedDateTime z2, Long status)) {
        }

        if (object instanceof String[] { String s1, String s2 }){
        }
        */
    }
}
