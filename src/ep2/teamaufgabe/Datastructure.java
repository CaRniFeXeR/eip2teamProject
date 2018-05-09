package ep2.teamaufgabe;

import ep2.teamaufgabe.Models.Location;

public interface Datastructure {
    String getName();
    void add(Location location);
    int[] countLocationsInArea(double x, double y, double r);
    int countAriportsNearTrainstation(double r, int n);
}
