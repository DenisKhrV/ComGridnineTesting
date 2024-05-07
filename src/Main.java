import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println(FlightBuilder.createFlights());
        System.out.println(LocalDateTime.now());
        System.out.println(FlightService.departureBeforeCurrentTime());
        System.out.println(FlightService.segmentsWithArrivalDateEarlierThanDepartureDate());
        FlightBuilder.createFlights().get(0).getSegments().get(0).getDepartureDate().
    }
}