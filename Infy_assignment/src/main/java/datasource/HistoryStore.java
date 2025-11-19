package datasource;

import domain.Location;
import domain.POI;

import java.util.List;

/**
 * In-memory runtime-only storage for historical data.
 */
public interface HistoryStore {

    void storeLocation(Location location);

    void storePOIResults(Location location, List<POI> poiList);

    List<Location> getLocationHistory();

    List<List<POI>> getPOIHistory();
}