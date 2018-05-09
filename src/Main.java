package ep2.teamaufgabe;

import ep2.teamaufgabe.Quadtree.Quadtree;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEAMAUFGABE");
        System.out.println("TEAMAUFGABE");
        System.out.println("Fabs initialized!");



        //Simple Data
        //DataReader.ReadData(listStucture,"simpleData.csv");

        double x = 1818.54657;
        double y = 5813.29982;
        double r = 100.0;
        int n = 5;

        LocationList listStucture = new LocationList();
        DataReader.ReadData(listStucture,"junctions.csv");
        int[] vList = listStucture.countLocationsInArea(x, y, r);
        System.out.println("List");
        System.out.println("Airports: " + vList[0]);
        System.out.println("Trainstations: " + vList[1]);
        System.out.println(listStucture.countAriportsNearTrainstation(r, n) + " Trainstations");
        System.out.println();

        Quadtree quadtree = new Quadtree(-81918465352051400d, 81918465352051400d, -59720745659516000d, 59720745659516000d);
        DataReader.ReadData(quadtree, "junctions.csv");
        int[] vTree = quadtree.countLocationsInArea(x, y, r);
        System.out.println("Quadtree");
        System.out.println("Airports: " + vTree[0]);
        System.out.println("Trainstations: " + vTree[1]);
        System.out.println(quadtree.countAriportsNearTrainstation(r, n) + " Trainstations");







    }
}
