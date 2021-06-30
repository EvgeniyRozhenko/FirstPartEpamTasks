package javacollections.maintask.stones;

import java.util.Objects;
import java.util.Random;

public abstract class Stone {
    private String stoneName;
    private double stoneCaratWeight;
    private double stoneCost;
    private String stoneColor;
    private int stoneTransparency;

    public Stone() {}

    public Stone(String stoneName, double stoneCaratWeight, String stoneColor, int stoneTransparency) {
        this.stoneName = stoneName;
        this.stoneCaratWeight = stoneCaratWeight;
        this.stoneColor = stoneColor;
        this.stoneTransparency = stoneTransparency;
    }

    public String getStoneName() {
        return stoneName;
    }

    public double getStoneCaratWeight() {
        return stoneCaratWeight;
    }

    public double getStoneCost() {
        return stoneCost;
    }

    public void setStoneCost(double stoneCost) {
        this.stoneCost = stoneCost;
    }

    public String getStoneColor() {
        return stoneColor;
    }

    public int getStoneTransparency() {
        return stoneTransparency;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stone stone = (Stone) o;
        return Double.compare(stone.stoneCaratWeight, stoneCaratWeight) == 0
                && Double.compare(stone.stoneCost, stoneCost) == 0
                && stoneTransparency == stone.stoneTransparency
                && stoneName.equals(stone.stoneName)
                && stoneColor.equals(stone.stoneColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stoneName, stoneCaratWeight, stoneCost, stoneColor, stoneTransparency);
    }

    public static double createRandomCaratWeightForStone() {
        Random randomGenerator = new Random();
        double d = randomGenerator.nextInt(501);
        if (d == 0){
            return (d + 1) / 100;
        }else {
            return d / 100;
        }
    }

    public abstract double estimateValueOfStone(String stoneName, double stoneCaratWeight);

}
