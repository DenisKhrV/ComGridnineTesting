import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
    /**
     * Вылет до текущего момента времени.
     */
    public static List<Flight> departureBeforeCurrentTime() {
        return FlightBuilder.createFlights().stream().filter(flight -> flight.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now())).toList();
    }
    /**
     * Сегменты с датой прилёта раньше даты вылета.
     */
    public static List<Segment> segmentsWithArrivalDateEarlierThanDepartureDate() {
        return FlightBuilder.createFlights().stream().flatMap(flight -> flight.getSegments().stream())
                .filter(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())).toList();
    }
    /**
     * Перелеты, где общее время, проведённое на земле, превышает два часа.
     */
    public static List<Flight> flightsWithTotalGroundTimeMoreThanTwoHours() {
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            int durationTotal = 0;

            for (int j = 0; j < segments.size() - 1; j++) {

                LocalDateTime arrivalDate = segments.get(j).getArrivalDate();
                LocalDateTime departureDate = segments.get(j + 1).getDepartureDate();

                Duration duration = Duration.between(arrivalDate, departureDate);
                durationTotal = durationTotal + duration.toHoursPart();
            }
            if (durationTotal > 2) {
                result.add(flight);
            }
        }
        return result;
    }
}
