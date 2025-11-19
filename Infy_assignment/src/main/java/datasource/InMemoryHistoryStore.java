package datasource;

import domain.Location;
import domain.POI;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores all history in memory while the app is running.
 * Requirement: data does not need to persist across launches.
 */
public class InMemoryHistoryStore implements HistoryStore {

    private final List<Location> locationHistory = new ArrayList<>();
    private final List<List<POI>> poiHistory = new ArrayList<>();

    @Override
    public void storeLocation(Location location) {
        locationHistory.add(location);
    }

    @Override
    public void storePOIResults(Location location, List<POI> poiList) {
        poiHistory.add(poiList);
    }

    @Override
    public List<Location> getLocationHistory() {
        return locationHistory;
    }

    @Override
    public List<List<POI>> getPOIHistory() {
        return poiHistory;
    }
}