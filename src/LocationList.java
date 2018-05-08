import Models.Airport;
import Models.Location;
import Models.Trainstation;

import java.util.ArrayList;

public class LocationList implements Datastructure {
    private ArrayList<Airport> airports = new ArrayList<>();
    private ArrayList<Trainstation> trainstations = new ArrayList<>();

    @Override
    public void add(Location location) {
       if(location.getClass() == Airport.class){
           this.airports.add((Airport) location);
       }else{
           this.trainstations.add((Trainstation) location);
       }
    }

    @Override
    public int[] countLocationsInArea(double x, double y, double r) {
        int airportCount = 0;
        int trainstationCount = 0;

        for(int i = 0; i < this.airports.size(); i++){
            double dx = this.airports.get(i).getXCoordiante() - x;
            double dy = this.airports.get(i).getYCoordinate() - y;
            double distance = Math.abs(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            if(distance <= r){
                airportCount++;
            }
        }


        for(int i = 0; i < this.trainstations.size(); i++){
            double dx = this.trainstations.get(i).getXCoordiante() - x;
            double dy = this.trainstations.get(i).getYCoordinate() - y;
            double distance = Math.abs(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            if(distance <= r){
                trainstationCount++;
            }
        }


        return new int[] {airportCount, trainstationCount};
    }

    @Override
    public int countAriportsNearTrainstation(double r, int n) {
        int airportCount = 0;

        for(int i = 0; i < this.airports.size(); i++){

            double x = this.airports.get(i).getXCoordiante();
            double y = this.airports.get(i).getYCoordinate();

            if(this.countLocationsInArea(x, y, r)[1] >= n){
                airportCount++;
            }

        }

        return airportCount;
    }
}
