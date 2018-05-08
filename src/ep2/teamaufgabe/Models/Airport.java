package ep2.teamaufgabe.Models;

public class Airport extends Location {

    public Airport(double x, double y, String name) {
        super(x,y,name);
        this.type = "Airport";
    }
}
