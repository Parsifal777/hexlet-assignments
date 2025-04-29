package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int number) {
        List<String> result = homes.stream()
                .sorted()
                .limit(number)
                .map(Home::toString)
                .collect(Collectors.toList());
        return result;
    }
}
// END
