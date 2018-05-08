package Models;

public abstract class Location {
    private double x;
    private  double y;
    private String name;

    protected String type;

    public Location(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;

    }

    //region [ Getter]
    public double getXCoordiante() {
        return x;
    }

    public double getYCoordinate() {
        return y;
    }

    public String getName() {
        return name;
    }

    //endregion
}
