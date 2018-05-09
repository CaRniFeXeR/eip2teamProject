package ep2.teamaufgabe.Models;

public class Trainstation extends Location {

    public Trainstation(double x, double y, String name) {
        super(x,y,name);
        this.type = "Trainstation";
    }
}