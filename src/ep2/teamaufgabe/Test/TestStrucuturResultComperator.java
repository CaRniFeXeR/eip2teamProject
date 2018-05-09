package ep2.teamaufgabe.Test;

import java.util.Comparator;

public class TestStrucuturResultComperator implements Comparator<TestStructurResult> {
    @Override
    public int compare(TestStructurResult x, TestStructurResult y) {
        return x.compareTo(y);
    }
}
