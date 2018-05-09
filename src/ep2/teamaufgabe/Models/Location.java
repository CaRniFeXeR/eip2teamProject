package ep2.teamaufgabe.Models;

public abstract class Location {
    private Point coordinates;
    private String name;

    protected String type;

    public Location(double x, double y, String name) {
        this.coordinates = new Point(x, y);
        this.name = name;

    }

    //region [ Getter]

    public double getXCoordiante() {
        return coordinates.getXCoordinate();
    }

    public double getYCoordinate() {
        return coordinates.getYCoordinate();
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    //endregion

    //region [public Methods]

    public void print() {
        System.out.println(this.name + " " + this.coordinates.getOutputString() + " - " + this.type);
    }

    //endregion
}
