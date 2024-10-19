import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Фильтр исключает из списка перелёты, где общее время, проведенное на земле, превышает два часа
 */
class FilterTotalGroundTimeMoreThanTwoHours implements Filter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            int durationTotal = 0;

            for (int i = 0; i < segments.size() - 1; i++) {

                LocalDateTime arrivalDate = segments.get(i).getArrivalDate();
                LocalDateTime departureDate = segments.get(i + 1).getDepartureDate();

                Duration duration = Duration.between(arrivalDate, departureDate);
                durationTotal = durationTotal + duration.toHoursPart();
            }
            if (durationTotal <= 2) {
                result.add(flight);
            }
        }
        return result;
    }
}
