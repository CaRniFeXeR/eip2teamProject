import Models.Location;

public interface Datastructure {
    void add(Location location);
    int[] countLocationsInArea(double x, double y, double r);
    int countAriportsNearTrainstation(double r, int n);
}
