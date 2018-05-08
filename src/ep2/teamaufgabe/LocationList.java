package ep2.teamaufgabe;

import ep2.teamaufgabe.Models.Airport;
import ep2.teamaufgabe.Models.Location;
import ep2.teamaufgabe.Models.Trainstation;

import java.util.ArrayList;

public class LocationList implements Datastructure {
    private ArrayList<Airport> airports = new ArrayList<>();
    private ArrayList<Trainstation> trainstations = new ArrayList<>();

    @Override
    public void add(Location location) {
        if (location.getClass() == Airport.class) {
            this.airports.add((Airport) location);
        } else {
            this.trainstations.add((Trainstation) location);
        }
    }

    @Override
    public int[] countLocationsInArea(double x, double y, double r) {
        int airportCount = this.getLocationsinAera(this.airports, x, y, r);
        int trainstationCount = this.getLocationsinAera(this.trainstations, x, y, r);


        return new int[]{airportCount, trainstationCount};
    }

    @Override
    public int countAriportsNearTrainstation(double r, int n) {
        int airportCount = 0;

        for (int i = 0; i < this.airports.size(); i++) {

            double x = this.airports.get(i).getXCoordiante();
            double y = this.airports.get(i).getYCoordinate();

            if (this.getLocationsinAera(this.trainstations, x, y, r) >= n) {
                airportCount++;
            }

        }

        return airportCount;
    }

    private int getLocationsinAera(ArrayList<? extends Location> source, double x, double y, double r) {
        int count = 0;
        for (int i = 0; i < source.size(); i++) {
            double dx = source.get(i).getXCoordiante() - x;
            double dy = source.get(i).getYCoordinate() - y;
            double distance = Math.abs(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            if (distance <= r) {
                count++;
            }
        }

        return count;
    }
}
