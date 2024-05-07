import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Flight> flightsWithTotalGroundTimeMoreThanTwoHours() {
        return new ArrayList<Flight>();
    }
}
