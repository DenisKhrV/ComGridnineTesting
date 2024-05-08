public class Main {
    public static void main(String[] args) {
        System.out.println(FlightBuilder.createFlights());

        System.out.println(FlightService.departureBeforeCurrentTime());
        System.out.println(FlightService.segmentsWithArrivalDateEarlierThanDepartureDate());
        System.out.println(FlightService.flightsWithTotalGroundTimeMoreThanTwoHours());
    }
}