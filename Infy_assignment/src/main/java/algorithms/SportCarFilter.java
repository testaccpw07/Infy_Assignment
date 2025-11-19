package algorithms;

import domain.Location;

/**
 * More responsive filtering for sport cars.
 * Assumption: sport models need finer adjustments.
 */
public class SportCarFilter implements LocationFilter {

    @Override
    public Location filter(Location rawLocation) {
        // Placeholder: a real filter would do complex calculations.
        return new Location(
                rawLocation.latitude() + 0.0001,
                rawLocation.longitude() + 0.0001
        );
    }
}