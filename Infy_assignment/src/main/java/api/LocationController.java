package api;

import domain.Location;
import services.LocationService;
import services.POIService;

/**
 * Acts as the "entry point" for raw location updates coming from the car system.
 */
public class LocationController {

    private final LocationService locationService;
    private final POIService poiService;
    private final UIInterface ui;

    public LocationController(
            LocationService locationService,
            POIService poiService,
            UIInterface ui
    ) {
        this.locationService = locationService;
        this.poiService = poiService;
        this.ui = ui;
    }

    public void onNewRawLocation(Location rawLocation) {
        Location filtered = locationService.processRawLocation(rawLocation);
        ui.showLocation(filtered);

        var pois = poiService.getPOIsForLocation(filtered);
        ui.showPOIs(pois);
    }
}