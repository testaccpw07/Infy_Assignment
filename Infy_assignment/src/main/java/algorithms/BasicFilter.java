package algorithms;

import domain.Location;

/**
 * Basic no-op filtering algorithm.
 * Assumption: low-end models only need minimal filtering.
 */
public class BasicFilter implements LocationFilter {

    @Override
    public Location filter(Location rawLocation) {
        // No filtering for now – a real algorithm would be applied here.
        return rawLocation;
    }
}