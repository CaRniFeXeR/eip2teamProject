package ep2.teamaufgabe.KDTree;

import ep2.teamaufgabe.Models.Location;
import ep2.teamaufgabe.Models.Point;

public class KDTreeNodeY extends KDTreeNode {

    //region [CTOR]
    public KDTreeNodeY(Location value) {
        super(value);
    }
    //endregion

    //region [KDTreeNode implementation]
    @Override
    protected KDTreeNode createNewChild(Location value) {
        return new KDTreeNodeX(value);
    }

    @Override
    public int compareKeyValue(Point value) {
        if (super.value.getYCoordinate() > value.getYCoordinate()) { // super.value > value
            return 1;
        } else if (super.value.getYCoordinate() < value.getYCoordinate()) { //super.vale < value
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    protected boolean isKeyValueInOffset(Point value, double offset) {
        return Math.abs(super.value.getYCoordinate() - value.getYCoordinate()) <= offset;
    }
    //endregion

}
