import Models.Airport;
import Models.Location;

import java.util.ArrayList;

public class LocationList implements Datastructure {
    private ArrayList<Location> locations = new ArrayList<>();

    @Override
    public void add(Location location) {
        this.locations.add(location);
    }

    @Override
    public int[] countLocationsInArea(double x, double y, double r) {
        int airports = 0;
        int trainstations = 0;

        for(int i = 0; i < this.locations.size(); i++){
            double dx = this.locations.get(i).getXCoordiante() - x;
            double dy = this.locations.get(i).getYCoordinate() - y;
            double distance = Math.abs(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            if (distance <= r){
                 if(this.locations.get(i).getClass() == Airport.class) {
                    airports++;
                }else{
                    trainstations++;
                }
            }

        }

        return new int[] {airports, trainstations};
    }

    @Override
    public int countAriportsNearTrainstation(double r, int n) {
        int airports = 0;

        for(int i = 0; i < this.locations.size(); i++){
            if(this.locations.get(i).getClass() == Airport.class){
                double x = this.locations.get(i).getXCoordiante();
                double y = this.locations.get(i).getYCoordinate();

                if(this.countLocationsInArea(x, y, r)[1] >= n){
                    airports++;
                }
            }
        }

        return airports;
    }
}
