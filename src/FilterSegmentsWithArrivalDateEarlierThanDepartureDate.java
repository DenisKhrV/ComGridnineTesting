import java.util.List;

/**
 * Фильтр исключает из списка перелёты, содержащие сегменты с датой прилета раньше даты вылета
 */
class FilterSegmentsWithArrivalDateEarlierThanDepartureDate implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments().stream()
                .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))).toList();
    }
}
