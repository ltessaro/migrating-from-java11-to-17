package stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import records.SimpleFlight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stream_Test {
    @Test
    public void givenAStreamOfIntegers_whenTransformToList_thenGetListEqualsToStream() {
        Stream<Integer> integers = Stream.of(12, 19, 23);
        assertEquals(List.of(12, 19, 23), integers.collect(Collectors.toList()));
    }

    @Tag("java16")
    @Test
    public void givenAStreamOfIntegers_whenTransformToListNewWay_thenGetListEqualsToStream() {
        Stream<Integer> integers = Stream.of(12, 19, 23);
        assertEquals(List.of(12, 19, 23), integers.toList());
    }

    @Tag("java")
    @Test
    public void givenAStream_whenFilterAndMap_thenProcessAndReturnAList() {
        Stream<SimpleFlight> flights = Stream.of(
                new SimpleFlight(1, 1),
                new SimpleFlight(2, 2),
                new SimpleFlight(3, 1));

        assertEquals(
                List.of(1, 3),
                flights.filter(f -> f.status() == 1)
                        .map(SimpleFlight::id)
                        .collect(Collectors.toList())
        );
    }

    @Tag("java16")
    @Test
    public void givenAStream_whenProcessUsingMapMulti_thenFilterAndTransform() {
        Stream<SimpleFlight> flights = Stream.of(
                new SimpleFlight(1, 1),
                new SimpleFlight(2, 2),
                new SimpleFlight(3, 1)
        );

        assertEquals(List.of(1, 3),
                flights.mapMulti(
                        (flight, mapper) -> {
                            if (flight.status() == 1) {
                                mapper.accept(flight.id());
                            }
                        }
                ).toList()
        );
    }

    @Tag("java16")
    @Test
    public void givenAStream_whenProcessUsingMapMulti_thenFilterAggregateAndTransform() {
        Stream<SimpleFlight> flights = Stream.of(
                new SimpleFlight(1, 1),
                new SimpleFlight(2, 2),
                new SimpleFlight(3, 1, new Integer[] { 1, 2 } )
        );

        assertEquals(List.of(1, -1, 3, 1, 2),
                flights.mapMulti(
                        (flight, mapper) -> {
                            if (flight.status() == 1) {
                                mapper.accept(flight.id());

                                if (flight.connections().length == 0) {
                                    mapper.accept(-1);
                                } else {
                                    for (Integer connection : flight.connections()) {
                                        mapper.accept(connection);
                                    }
                                }
                            }
                        }
                ).toList()
        );
    }
}
