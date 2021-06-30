package javacollections.maintask.stones;

import java.text.DecimalFormat;

public class Gem extends Stone {

    public Gem() {}

    public Gem(String gemName, double gemCaratWeight, String gemColor, int gemTransparency) {
        super(gemName, gemCaratWeight, gemColor, gemTransparency);
    }

    @Override
    public String toString() {
        return "Gem {" +
                "gemName='" + super.getStoneName() + '\'' +
                ", gemCaratWeight=" + super.getStoneCaratWeight() +
                ", gemCost=" + super.getStoneCost() +
                ", gemColor='" + super.getStoneColor() + '\'' +
                ", gemTransparency='" + super.getStoneTransparency() + '\'' +
                "}" + '\n';
    }

    public double estimateValueOfStone(String gemName, double gemCaratWeight) {
        int gemCostPerOneCarat;
        switch (gemName) {
            case "Diamond":
                gemCostPerOneCarat = 10_000;
                break;
            case "Aquamarine":
                gemCostPerOneCarat = 5_000;
                break;
            case "Emerald":
                gemCostPerOneCarat = 9_000;
                break;
            case "Opal":
                gemCostPerOneCarat = 5_500;
                break;
            case "Ruby":
                gemCostPerOneCarat = 7_500;
                break;
            case "Sapphire":
                gemCostPerOneCarat = 8_000;
                break;
            case "Topaz":
                gemCostPerOneCarat = 7_000;
                break;
            default:
                gemCostPerOneCarat = 3_500;
                break;
        }
        double gemTotalCost = gemCaratWeight * gemCaratWeight * gemCostPerOneCarat;
        DecimalFormat formatOfNumber = new DecimalFormat("0.0");
        String formatOfNumberInString = String.valueOf(formatOfNumber.format(gemTotalCost)).replace(",", ".");

        return Double.parseDouble(formatOfNumberInString);
    }
}
