package ep2.teamaufgabe;

import ep2.teamaufgabe.KDTree.KDTreeStructure;
import ep2.teamaufgabe.Quadtree.Quadtree;
import ep2.teamaufgabe.Test.Tester;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEAMAUFGABE init");

        ArrayList<Datastructure> datastructures = new ArrayList<>();


        datastructures.add(new KDTreeStructure());
        datastructures.add(new Quadtree(-81918465352051400d, 81918465352051400d, -59720745659516000d, 59720745659516000d));
        // datastructures.add(new LocationList());

        Tester test = new Tester();

        test.testAndComparePerofrmance(datastructures, "junctions.csv", 4, true);

        // DataReader.ReadData(twoDimensionTree,"junctions.csv");

        // twoDimensionTree.print();

        //System.out.println(twoDimensionTree.countLocationsInArea(0,0,2)[1]);
        //  System.out.println("Number of Airports with n Trainsatation in an Distance of 15 " + twoDimensionTree.countAriportsNearTrainstation(1,5));
        //System.out.println(twoDimensionTree.countLocationsInArea(0,0,10)[0]);


        //Simple Data
        //DataReader.ReadData(listStucture,"simpleData.csv");

        //big Data
        //DataReader.ReadData(listStucture,"junctions.csv");

        //System.out.println("Number of Trainstations :" + listStucture.countLocationsInArea(0,0,6)[1]);
        //System.out.println("Number of Airports with n Trainsatation in an Distance of 1 " + listStucture.countAriportsNearTrainstation(1,5));
    }
}
