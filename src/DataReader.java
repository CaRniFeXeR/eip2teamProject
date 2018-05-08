import Models.Airport;
import Models.Location;
import Models.Trainstation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataReader {

    public static void ReadData(Datastructure datastructure) {
        try (Scanner s = new Scanner(
                new File(System.getProperty("user.dir") +
                        "/data/junctions.csv"), "UTF-8")) {
            while (s.hasNextLine()) {
                Location currentLocation = DataReader.parseLocation(s.nextLine());

                if (currentLocation != null) {
                    datastructure.add(currentLocation);
                }
            }
        } catch (FileNotFoundException e) {
            // junctions.csv wurde nicht gefunden
            System.out.println("'junctions.csv' wurde nicht gefunden");
            System.exit(1);
        }
    }

    private static Location parseLocation(String input) {
        if (input != null || !input.isEmpty()) {
            return null;
        }

        String[] seperated = input.split(";");

        if (seperated.length != 4) {
            return null;
        }

        if (seperated[3].equals("TRAINSTATION")) {
            return new Trainstation(Double.parseDouble(seperated[1]), Double.parseDouble(seperated[2]), seperated[0]);

        } else if (seperated[3].equals("AIRPORT")) {
            return new Airport(Double.parseDouble(seperated[1]), Double.parseDouble(seperated[2]), seperated[0]);
        }

        return null;
    }

}
