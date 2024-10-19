import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestFilters {
    List<Flight> flightList = new ArrayList<>();
    LocalDateTime now = LocalDateTime.now();
    Flight flight1 = createFlight(now.plusHours(1), now.minusHours(2));
    Flight flight2 = createFlight(now.minusHours(2), now.plusHours(1));
    Flight flight3 = createFlight(now.minusHours(1), now.plusHours(3), now.plusHours(6), now.minusHours(1));
    Flight flight4 = createFlight(now.plusHours(2), now.plusHours(4), now.plusHours(7), now.plusHours(11));
    Flight flight5 = createFlight(now, now.plusHours(5));

    @BeforeEach
    public void addFlights() {
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);
    }

    @Test
    void testDepartureBeforeCurrentTime() {
        List<Flight> expectedList = new ArrayList<>(flightList);
        expectedList.remove(flight2);
        expectedList.remove(flight3);

        Filter filter = new FilterDepartureBeforeCurrentTime();
        List<Flight> actualList = filter.filter(flightList);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void testSegmentsWithArrivalDateEarlierThanDepartureDate() {
        List<Flight> expectedList = new ArrayList<>(flightList);
        expectedList.remove(flight1);
        expectedList.remove(flight3);

        Filter filter = new FilterSegmentsWithArrivalDateEarlierThanDepartureDate();
        List<Flight> actualList = filter.filter(flightList);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void testTotalGroundTimeMoreThanTwoHours() {
        List<Flight> expectedList = new ArrayList<>(flightList);
        expectedList.remove(flight3);
        expectedList.remove(flight4);

        Filter filter = new FilterTotalGroundTimeMoreThanTwoHours();
        List<Flight> actualList = filter.filter(flightList);
        Assertions.assertEquals(expectedList, actualList);
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

