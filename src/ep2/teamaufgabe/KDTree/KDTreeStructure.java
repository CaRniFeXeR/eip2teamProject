package ep2.teamaufgabe.KDTree;

import ep2.teamaufgabe.Datastructure;
import ep2.teamaufgabe.Models.Airport;
import ep2.teamaufgabe.Models.Location;
import ep2.teamaufgabe.Models.Point;
import ep2.teamaufgabe.Models.Trainstation;

import java.util.ArrayList;

public class KDTreeStructure implements Datastructure {

    //region [private Fields]

    private ArrayList<Airport> airportsArrayList;
    private KDTree airports;
    private KDTree trainstationts;

    //endregion

    //region [CTOR]

    public KDTreeStructure() {
        this.airportsArrayList = new ArrayList<Airport>();
        this.trainstationts = new KDTree();
        this.airports = new KDTree();
    }

    //endregion

    //region [Datastructure implementation]


    @Override
    public String getName() {
        return "2D-Tree";
    }

    @Override
    public void add(Location location) {
        if (location.getClass() == Trainstation.class) {
            this.trainstationts.add(location);
        } else if (location.getClass() == Airport.class) {
            this.airports.add(location);
            this.airportsArrayList.add((Airport) location);
        }
    }

    @Override
    public int countAriportsNearTrainstation(double r, int n) {
        int airportCount = 0;

        for (int i = 0; i < this.airportsArrayList.size(); i++) {

            if (this.trainstationts.countSubNodesInCircel(this.airportsArrayList.get(i).getCoordinates(), r) >= n) {
                airportCount++;
            }

        }

        return airportCount;
    }

    @Override
    public int[] countLocationsInArea(double x, double y, double r) {
        Point center = new Point(x, y);

        int countAirport = this.airports.countSubNodesInCircel(center, r);
        int countTrainstation = this.trainstationts.countSubNodesInCircel(center, r);

        return new int[]{countAirport, countTrainstation};
    }

    //endregion

    //region [Public Methods]

    public void print() {
        if (this.airports != null) {
            System.out.println("Airports printing: ");
            this.airports.print();
            System.out.println("");
        }
        if (this.trainstationts != null) {
            System.out.println("Trainstations printing: \n");
            this.trainstationts.print();
        }
    }

    //endregion
}
