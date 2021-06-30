/*
4. Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
 */
package javacollections.optionaltasks.secondtask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Poem implements Comparator<String> {

    public Path getAbsoluteFilePath(String relativeFilePath) {
        return Paths.get(relativeFilePath).toAbsolutePath();
    }

    public List<String> readAllLinesFromTextFile(Path absoluteFilePath) {
        List<String> lines = null;
        try
        {
            lines = Files.readAllLines(absoluteFilePath);
        }
        catch (IOException e)
        {
            System.out.print("Wrong file path specified! ");
            e.printStackTrace();
        }

        return lines;
    }

    public void sortByAscendingOrderOfLinesLengths(List<String> lines) {
        for (int i = 0; i < lines.size()-1; i++) {
            lines.sort(new Poem());
        }
    }

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args) {
        Poem poemItemHelper = new Poem();

        Path absoluteFilePath = poemItemHelper.getAbsoluteFilePath("src\\main\\java\\javacollections\\optionaltasks\\secondtask\\Pushkin.txt");
        List<String> contentOfFileBylines = poemItemHelper.readAllLinesFromTextFile(absoluteFilePath);
        poemItemHelper.sortByAscendingOrderOfLinesLengths(contentOfFileBylines);

        for (String value: contentOfFileBylines) {
            System.out.println(value);
        }

    }
}
