package ep2.teamaufgabe;

import ep2.teamaufgabe.Test.Tester;
import ep2.teamaufgabe.KDTree.KDTreeStructure;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEAMAUFGABE");
        System.out.println("TEAMAUFGABE");
        System.out.println("Fabs initialized!");

        ArrayList<Datastructure> datastructures = new ArrayList<>();



        datastructures.add(new KDTreeStructure());
        datastructures.add(new LocationList());

        Tester test = new Tester();

        test.testAndComparePerofrmance(datastructures,"junctions.csv",false);

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
