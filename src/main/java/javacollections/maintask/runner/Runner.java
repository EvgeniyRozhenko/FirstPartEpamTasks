/*
Задание. Создать консольное приложение, удовлетворяющее следующим требованиям:
- Каждый класс должен иметь отражающее смысл название и информативный состав.
- Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
- Наследование должно применяться только тогда, когда это имеет смысл.
- При кодировании должны быть использованы соглашения об оформлении кода java code convention.
- Классы должны быть грамотно разложены по пакетам
- Консольное меню должно быть минимальным.
- Для хранения параметров инициализации можно использовать файлы.
6. Камни. Определить иерархию драгоценных и полудрагоценных камней. Отобрать камни для ожерелья. Подсчитать общий вес
(вкаратах) и стоимость. Провести сортировку камней ожерелья на основе ценности. Найти камни в ожерелье, соответствующие
заданному диапазону параметров прозрачности.
 */
package javacollections.maintask.runner;

import javacollections.maintask.necklace.Necklace;
import javacollections.maintask.stones.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        ArrayList<Stone> stoneCollection = new ArrayList<>() {
            {
                add(new Gem("Stone", Stone.createRandomCaratWeightForStone(), StoneColor.VIOLET.name(), StoneTransparency.VERY_CLOUDY.typeNumberScale));
                add(new Gem("Diamond", Stone.createRandomCaratWeightForStone(), StoneColor.WHITE.name(), StoneTransparency.COLORLESS.typeNumberScale));
                add(new Gem("Aquamarine", Stone.createRandomCaratWeightForStone(), StoneColor.BLUE.name(), StoneTransparency.VERY_LIGHT.typeNumberScale));
                add(new Gem("Emerald", Stone.createRandomCaratWeightForStone(), StoneColor.GREEN.name(), StoneTransparency.MEDIUM_LIGHT.typeNumberScale));
                add(new Gem("Pearl", Stone.createRandomCaratWeightForStone(), StoneColor.WHITE.name(), StoneTransparency.IMPENETRABLE.typeNumberScale));
                add(new Gem("Opal", Stone.createRandomCaratWeightForStone(), StoneColor.MULTICOLORED.name(), StoneTransparency.VERY_CLOUDY.typeNumberScale));
                add(new Gem("Ruby", Stone.createRandomCaratWeightForStone(), StoneColor.RED.name(), StoneTransparency.CLOUDY.typeNumberScale));
                add(new Gem("Sapphire", Stone.createRandomCaratWeightForStone(), StoneColor.CYAN.name(), StoneTransparency.MEDIUM.typeNumberScale));
                add(new Gem("Topaz", Stone.createRandomCaratWeightForStone(), StoneColor.YELLOW.name(), StoneTransparency.LIGHT_COLOURED.typeNumberScale));
                add(new SemipreciousStone("Nephrite", Stone.createRandomCaratWeightForStone(), StoneColor.GREEN.name(), StoneTransparency.MEDIUM_CLOUDY.typeNumberScale));
                add(new SemipreciousStone("Obsidian", Stone.createRandomCaratWeightForStone(), StoneColor.BLACK.name(), StoneTransparency.IMPENETRABLE.typeNumberScale));
                add(new SemipreciousStone("Coral", Stone.createRandomCaratWeightForStone(), StoneColor.PINK.name(), StoneTransparency.EXTREMELY_CLOUDY.typeNumberScale));
                add(new SemipreciousStone("Moonstone", Stone.createRandomCaratWeightForStone(), StoneColor.BLUE.name(), StoneTransparency.MEDIUM_LIGHT.typeNumberScale));
                add(new SemipreciousStone("Malachite", Stone.createRandomCaratWeightForStone(), StoneColor.GREEN.name(), StoneTransparency.EXTREMELY_CLOUDY.typeNumberScale));
                add(new SemipreciousStone("Turquoise", Stone.createRandomCaratWeightForStone(), StoneColor.CYAN.name(), StoneTransparency.IMPENETRABLE.typeNumberScale));
                add(new SemipreciousStone("Agate", Stone.createRandomCaratWeightForStone(), StoneColor.MULTICOLORED.name(), StoneTransparency.MEDIUM_CLOUDY.typeNumberScale));
                add(new SemipreciousStone("Amethyst", Stone.createRandomCaratWeightForStone(), StoneColor.PURPLE.name(), StoneTransparency.VERY_LIGHT.typeNumberScale));
            }
        };

        stoneCollection.removeIf(stone -> stone.getStoneCaratWeight() < 1);
        stoneCollection.forEach(stone -> stone.setStoneCost(stone.estimateValueOfStone(stone.getStoneName(), stone.getStoneCaratWeight())));
        Necklace necklaceWithStones = new Necklace("Gold", stoneCollection);
        System.out.println("Отобранные камни для ожерелья: " + '\n' + stoneCollection + '\n');

        double[] totalWeightAndCostOfStonesInNecklace = necklaceWithStones.calculateTotalWeightAndCostOfStonesInNecklace(necklaceWithStones.getSocketsForStone());
        System.out.println("Посчитанный общий вес в каратах и стоимость камней в ожерелье: " + '\n' + Arrays.toString(totalWeightAndCostOfStonesInNecklace) + '\n');

        necklaceWithStones.sortNecklaceStonesByCost();
        System.out.println("Сортировка камней ожерелья на основе ценности: " + '\n' + necklaceWithStones.getSocketsForStone() + '\n');

        List<Stone> setOfStonesRangedByTransparencyParameter = necklaceWithStones.findStonesInNecklaceMatchingSpecifiedRangeOfTransparencyParameter(6, 7);
        System.out.println("Камни в ожерелье, соответствующие заданному диапазону параметров прозрачности: " + '\n' + setOfStonesRangedByTransparencyParameter);
    }
}
