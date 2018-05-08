import Models.Location;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEAMAUFGABE");
        System.out.println("TEAMAUFGABE");
        System.out.println("Fabs initialized!");

        LocationList list = new LocationList();
        DataReader.ReadData(list);
        System.out.println(list.countLocationsInArea(0.0, 0.0, 78055556)[1]);
    }
}
