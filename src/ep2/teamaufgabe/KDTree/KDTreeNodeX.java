package ep2.teamaufgabe.KDTree;

import ep2.teamaufgabe.Models.Location;
import ep2.teamaufgabe.Models.Point;

public class KDTreeNodeX extends KDTreeNode {

    //region [CTOR]
    public KDTreeNodeX(Location value) {
        super(value);
    }
    //endregion

    //region [KDTreeNode implementation]

    @Override
    protected KDTreeNode createNewChild(Location value) {
        return new KDTreeNodeY(value);
    }

    @Override
    public int compareKeyValue(Point value) {
        if (super.value.getXCoordiante() > value.getXCoordinate()) { // super.value > value
            return 1;
        } else if (super.value.getXCoordiante() < value.getXCoordinate()) { //super.value < value
            return -1;
        } else {
            return 0;           // super.value == value
        }
    }

    @Override
    protected boolean isKeyValueInOffset(Point value, double offset) {
        return Math.abs(super.value.getXCoordiante() - value.getXCoordinate()) <= offset;
    }

    //endregion

}
