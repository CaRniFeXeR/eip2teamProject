package ep2.teamaufgabe.KDTree;

import ep2.teamaufgabe.Models.Location;
import ep2.teamaufgabe.Models.Point;

public abstract class KDTreeNode {

    //region [Fields]

    protected Location value;
    protected KDTreeNode left;
    protected KDTreeNode right;

    //endregion

    //region [CTOR]

    public KDTreeNode(Location value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    //endregion

    //region [Abstract Methods]

    protected abstract KDTreeNode createNewChild(Location value);

    public abstract int compareKeyValue(Point value);

    protected abstract boolean isKeyValueInOffset(Point value, double offset);

    //endregion

    //region [Public Methods]

    public int compareKeyValue(Location value) {
        return this.compareKeyValue(value.getCoordinates());
    }

    public int countSubNodesInCircel(Point center, double r) {
        boolean isInCircel = this.value.getCoordinates().isInCircel(center, r);

        int count = isInCircel ? 1 : 0;

        if (isInCircel || this.compareKeyValue(center) <= 0 || this.isKeyValueInOffset(center, r)) {      // value > this.value
            if (this.right != null) {
                count += this.right.countSubNodesInCircel(center, r);
            }
        }

        //if current Node is in Circel both Subtrees are relevant
        if (isInCircel || this.compareKeyValue(center) >= 0 || this.isKeyValueInOffset(center, r)) {// value < this.value
            if (this.left != null) {
                count += this.left.countSubNodesInCircel(center, r);
            }
        }

        return count;
    }

    public void add(Location value) {
        if (this.compareKeyValue(value) < 0) { // value > this.value
            if (right != null) {
                right.add(value);
            } else {
                right = this.createNewChild(value);
            }
        } else if (this.compareKeyValue(value) >= 0) {         // value <= this.value
            if (left != null) {
                left.add(value);
            } else {
                left = this.createNewChild(value);
            }
        }
    }

    public void print() {
        if (this.left != null) {  //left <= top < right
            this.left.print();
        }

        this.value.print();

        if (this.right != null) {
            this.right.print();
        }
    }

    //endregion


}
