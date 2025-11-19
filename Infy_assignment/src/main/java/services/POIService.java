package services;

import datasource.HistoryStore;
import domain.Location;
import domain.POI;

import java.util.List;

/**
 * Retrieves Points of Interest (restaurants, charging stations, etc.)
 * around a location. Actual API calls are not required for this assignment.
 */
public class POIService {

    private final HistoryStore store;

    public POIService(HistoryStore store) {
        this.store = store;
    }

    public List<POI> getPOIsForLocation(Location location) {

        // Placeholder external API call
        // In reality, we'd call something like:
        //     List<POI> poiList = externalPoiApi.fetchData(location);
        // But for the assignment we use dummy data.

        List<POI> pois = List.of(
                new POI("Restaurant A", "Restaurant", location),
                new POI("Charging Station X", "Charging", location)
        );

        store.storePOIResults(location, pois);
        return pois;
    }
}