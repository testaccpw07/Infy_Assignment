package algorithms;

import domain.Location;

/**
 * Interface representing a pluggable location filter algorithm.
 */
public interface LocationFilter {
    Location filter(Location rawLocation);
}