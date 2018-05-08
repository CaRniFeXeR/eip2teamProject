package ep2.teamaufgabe.Models;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getXCoordinate() {
        return x;
    }

    public double getYCoordinate() {
        return y;
    }

    public boolean isInCircel(Point center, double r) {
        return this.getDistance(center) <= r;
    }

    public double getDistance(Point anotherPoint) {
        double dx = anotherPoint.x - x;
        double dy = anotherPoint.y - y;

        return Math.abs(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }

    public String getOutputString() {
        return this.x + " : " + this.y;
    }
}