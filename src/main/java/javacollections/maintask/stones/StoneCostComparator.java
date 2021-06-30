package javacollections.maintask.stones;

import java.util.Comparator;

public class StoneCostComparator implements Comparator<Stone> {
    @Override
    public int compare(Stone o1, Stone o2) {
        return Double.compare(o1.getStoneCost(), o2.getStoneCost());
    }
}
