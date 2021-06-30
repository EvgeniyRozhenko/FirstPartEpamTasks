package javacollections.maintask.stones;

import java.text.DecimalFormat;

public class SemipreciousStone extends Stone{

    public SemipreciousStone() {}

    public SemipreciousStone(String semipreciousStoneName, double semipreciousStoneCaratWeight, String semipreciousStoneColor, int semipreciousStoneTransparency) {
        super(semipreciousStoneName, semipreciousStoneCaratWeight, semipreciousStoneColor, semipreciousStoneTransparency);
    }

    @Override
    public String toString() {
        return "SemipreciousStone {" +
                "SemipreciousStoneName='" + super.getStoneName() + '\'' +
                ", SemipreciousStoneCaratWeight=" + super.getStoneCaratWeight() +
                ", SemipreciousStoneCost=" + super.getStoneCost() +
                ", SemipreciousStoneColor='" + super.getStoneColor() + '\'' +
                ", SemipreciousStoneTransparency=" + super.getStoneTransparency() +
                "} " + '\n';
    }

    public double estimateValueOfStone(String semipreciousStoneName, double semipreciousStoneCaratWeight) {
        int semipreciousStoneCostPerOneCarat;
        switch (semipreciousStoneName) {
            case "Nephrite":
                semipreciousStoneCostPerOneCarat = 1300;
                break;
            case "Coral":
            case "Moonstone":
                semipreciousStoneCostPerOneCarat = 2_500;
                break;
            case "Malachite":
                semipreciousStoneCostPerOneCarat = 500;
                break;
            case "Turquoise":
                semipreciousStoneCostPerOneCarat = 1_500;
                break;
            case "Agate":
                semipreciousStoneCostPerOneCarat = 1_000;
                break;
            case "Amethyst":
                semipreciousStoneCostPerOneCarat = 2_000;
                break;
            default:
                semipreciousStoneCostPerOneCarat = 250;
                break;
        }
        double semipreciousStoneTotalCost = semipreciousStoneCaratWeight * semipreciousStoneCaratWeight * semipreciousStoneCostPerOneCarat;
        DecimalFormat formatOfNumber = new DecimalFormat("0.0");
        String formatOfNumberInString = String.valueOf(formatOfNumber.format(semipreciousStoneTotalCost)).replace(",", ".");

        return Double.parseDouble(formatOfNumberInString);
    }
}
