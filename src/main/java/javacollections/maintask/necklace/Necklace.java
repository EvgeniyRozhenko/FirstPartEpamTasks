package javacollections.maintask.necklace;

import javacollections.maintask.stones.Stone;
import javacollections.maintask.stones.StoneCostComparator;

import java.util.List;
import java.util.stream.Collectors;

public class Necklace {
    private String typeOfMetal;
    private List<Stone> socketsForStone;

    public Necklace() {}

    public Necklace(String typeOfMetal, List<Stone> socketsForStone) {
        this.typeOfMetal = typeOfMetal;
        this.socketsForStone = socketsForStone;
    }

    public String getTypeOfMetal() {
        return typeOfMetal;
    }

    public List<Stone> getSocketsForStone() {
        return socketsForStone;
    }

    public double[] calculateTotalWeightAndCostOfStonesInNecklace(List<Stone> stoneCollection) {
        int totalWeight = 0;
        int totalCost = 0;

        for(Stone stone: stoneCollection) {
            totalWeight += stone.getStoneCaratWeight();
            totalCost += stone.getStoneCost();
        }
        return new double[]{totalWeight, totalCost};
    }

    public void sortNecklaceStonesByCost() {
        this.getSocketsForStone().sort(new StoneCostComparator());
    }

    public List<Stone> findStonesInNecklaceMatchingSpecifiedRangeOfTransparencyParameter(int from, int to) {
        return socketsForStone.stream().filter(stone -> (stone.getStoneTransparency() >= from
                && stone.getStoneTransparency() <= to)).collect(Collectors.toList());
    }
}
