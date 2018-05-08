package ep2.teamaufgabe.KDTree;

import ep2.teamaufgabe.Models.Location;
import ep2.teamaufgabe.Models.Point;

public class KDTree {

    //region [private Fields]
    private KDTreeNodeX root;
    //endregion

    //region [CTOR]
    public KDTree() {
        this.root = null;
    }
    //endregion

    //region [public Methods]

    public void add(Location location) {
        if (root == null) {
            root = new KDTreeNodeX(location);
        } else {
            root.add(location);
        }
    }

    public void print() {
        if (root != null) {
            root.print();
        }
    }

    public int countSubNodesInCircel(Point center, double r) {
        if (root != null) {
            return this.root.countSubNodesInCircel(center, r);
        }

        return -1;
    }

    //endregion

}
