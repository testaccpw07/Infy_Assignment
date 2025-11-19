package api;

import domain.Location;
import domain.POI;

import java.util.List;

/**
 * Only an interface since UI is not part of the project requirement.
 */
public interface UIInterface {
    void showLocation(Location location);
    void showPOIs(List<POI> pois);
}