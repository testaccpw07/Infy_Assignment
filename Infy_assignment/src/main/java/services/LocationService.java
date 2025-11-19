package services;

import algorithms.LocationFilter;
import datasource.HistoryStore;
import domain.Location;

/**
 * Handles filtering of incoming raw location signals.
 */
public class LocationService {

    private final LocationFilter filter;
    private final HistoryStore store;

    public LocationService(LocationFilter filter, HistoryStore store) {
        this.filter = filter;
        this.store = store;
    }

    public Location processRawLocation(Location raw) {
        Location filtered = filter.filter(raw);
        store.storeLocation(filtered);
        return filtered;
    }
}