import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(FlightBuilder.createFlights());
        List<Flight> flights = FlightBuilder.createFlights();

        Filter filter = new DepartureBeforeCurrentTime();
        System.out.println(filter.filter(flights));


        System.out.println(FlightService.departureBeforeCurrentTime());
        System.out.println(FlightService.segmentsWithArrivalDateEarlierThanDepartureDate());
//        System.out.println(FlightService.flightsWithTotalGroundTimeMoreThanTwoHours());
    }
}