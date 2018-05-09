package ep2.teamaufgabe.Quadtree;

import ep2.teamaufgabe.Datastructure;
import ep2.teamaufgabe.Models.Location;

public class Quadtree implements Datastructure {
    private QuadtreeNode root;
    private double minX, maxX, minY, maxY;

    public Quadtree(double minX, double maxX, double minY, double maxY){
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public void add(Location location) {
        if(this.root == null){
            this.root = new QuadtreeNode(this.minX, this.maxX, this.minY, this.maxY);
        }else{
            this.root.add(location);
        }
    }

    @Override
    public int[] countLocationsInArea(double x, double y, double r) {
        if(this.root == null){
            return new int[] {0, 0};
        }


        return this.root.countLocationsInArea(x, y, r);
    }

    @Override
    public int countAriportsNearTrainstation(double r, int n) {
        if(this.root == null){
            return 0;
        }
        return this.root.countAriportsNearTrainstation(r, n, this.root);
    }
}
