package ep2.teamaufgabe;

import ep2.teamaufgabe.KDTree.KDTreeStructure;
import ep2.teamaufgabe.Quadtree.Quadtree;
import ep2.teamaufgabe.Test.Tester;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEAMAUFGABE init");

        ArrayList<Datastructure> datastructures = new ArrayList<>();


        datastructures.add(new Quadtree(-81918465352051400d, 81918465352051400d, -59720745659516000d, 59720745659516000d));
        datastructures.add(new KDTreeStructure());
        //add Simplelist to compare
        //datastructures.add(new LocationList());


        Tester test = new Tester();

       /* TestInput[] instructsToTest = new TestInput[1];
        instructsToTest[0] = new TestInput(25.24419229708292, 19);
        test.testAndComparePerformance(datastructures, instructsToTest, "junctions.csv", true);
        */

        test.testAndComparePerofrmance(datastructures, "junctions.csv", 400, true);


    }
}
