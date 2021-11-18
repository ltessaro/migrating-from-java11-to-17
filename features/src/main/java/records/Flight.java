package records;

import java.time.ZonedDateTime;

public record Flight(Long id, ZonedDateTime startDate, ZonedDateTime endDate, Long status) {
}
