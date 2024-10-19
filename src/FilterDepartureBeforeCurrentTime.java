import java.time.LocalDateTime;
import java.util.List;

/**
 * Фильтр исключает из списка вылеты до текущего момента времени.
 */
class FilterDepartureBeforeCurrentTime implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(flight -> !flight.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now())).toList();
    }
}
