import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(FlightBuilder.createFlights());

        List<Flight> flights = FlightBuilder.createFlights();

        Filter filterDepartureBeforeCurrentTime = new FilterDepartureBeforeCurrentTime();
        Filter filterSegmentsWithArrivalDateEarlierThanDepartureDate = new FilterSegmentsWithArrivalDateEarlierThanDepartureDate();
        Filter filterTotalGroundTimeMoreThanTwoHours = new FilterTotalGroundTimeMoreThanTwoHours();

        System.out.println(filterDepartureBeforeCurrentTime.filter(flights));
        System.out.println(filterSegmentsWithArrivalDateEarlierThanDepartureDate.filter(flights));
        System.out.println(filterTotalGroundTimeMoreThanTwoHours.filter(flights));
    }
}