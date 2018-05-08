import Models.Location;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEAMAUFGABE");
        System.out.println("TEAMAUFGABE");
        System.out.println("Fabs initialized!");

        LocationList listStucture = new LocationList();


        //Simple Data
        DataReader.ReadData(listStucture,"simpleData.csv");

        //big Data
        //DataReader.ReadData(listStucture,"junctions.csv");

        System.out.println("Number of Trainstations :" + listStucture.countLocationsInArea(0,0,6)[1]);
    }
}
