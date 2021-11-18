package records;

import java.time.ZonedDateTime;
import java.util.Objects;

public record FlightWithCompactConstructor(Long id, ZonedDateTime startDate, ZonedDateTime endDate, Long status) {
    public FlightWithCompactConstructor {
        if (Objects.nonNull(startDate) && Objects.nonNull(endDate)) {
            if (endDate.isBefore(startDate)) throw new IllegalArgumentException("startDate must be before endDate");
        }
    }
}
