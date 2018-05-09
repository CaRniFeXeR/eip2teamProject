package ep2.teamaufgabe.Test;

import ep2.teamaufgabe.Datastructure;

public class TestInput {
    private double x, y, r;
    private int n;
    private boolean isCountAirports;

    public TestInput(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isCountAirports = false;
    }

    public TestInput(double r, int n) {
        this.r = r;
        this.n = n;
        this.isCountAirports = true;
    }

    public Object runMethod(Datastructure inputStructre) {
        if (inputStructre == null) {
            return null;
        }
        if (isCountAirports) {
            return inputStructre.countAriportsNearTrainstation(this.r, this.n);
        } else {
            return inputStructre.countLocationsInArea(this.x, this.y, this.r);
        }
    }
}
