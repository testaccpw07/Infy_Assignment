import algorithms.BasicFilter;
import algorithms.LocationFilter;
import algorithms.SportCarFilter;
import api.LocationController;
import api.UIInterface;
import datasource.HistoryStore;
import datasource.InMemoryHistoryStore;
import domain.Location;
import services.LocationService;
import services.POIService;

public class Main {
    public static void main(String[] args) {

        // Assumption: car model is detected at startup
        String carModel = "SPORT";

        LocationFilter filter = switch (carModel) {
            case "SPORT" -> new SportCarFilter();
            default -> new BasicFilter();
        };

        HistoryStore store = new InMemoryHistoryStore();
        LocationService locationService = new LocationService(filter, store);
        POIService poiService = new POIService(store);

        // Dummy UI implementation
        UIInterface ui = new UIInterface() {
            @Override
            public void showLocation(Location location) {
                System.out.println("Filtered location: " + location);
            }

            @Override
            public void showPOIs(java.util.List<domain.POI> pois) {
                System.out.println("Nearby POIs: " + pois);
            }
        };

        LocationController controller = new LocationController(locationService, poiService, ui);

        // Simulate a raw location signal
        controller.onNewRawLocation(new Location(52.12345, 13.54321));
    }
}