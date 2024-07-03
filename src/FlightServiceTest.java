import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FlightServiceTest {
    List<Flight> flightList = new ArrayList<>();
    List<Flight> flightList1= FlightBuilder.createFlights();


    @BeforeEach
    public void addFlights() {
        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = createFlight(now, now.plusHours(3));
        Flight flight2 = createFlight(now.minusHours(2), now);
        Flight flight3 = createFlight(now.minusHours(1), now.plusHours(3), now.plusHours(6), now.plusHours(12));
        Flight flight4 = createFlight(now, now.plusHours(4), now.plusHours(7), now.plusHours(11));
        Flight flight5 = createFlight(now, now.plusHours(5));
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);

    }

    @Test
    void departureBeforeCurrentTime() {

    }

    @Test
    void segmentsWithArrivalDateEarlierThanDepartureDate() {

    }

    @Test
    void flightsWithTotalGroundTimeMoreThanTwoHours() {
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}