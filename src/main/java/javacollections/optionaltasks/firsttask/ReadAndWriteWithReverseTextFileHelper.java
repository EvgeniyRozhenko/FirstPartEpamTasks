/*
1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 */
package javacollections.optionaltasks.firsttask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ReadAndWriteWithReverseTextFileHelper extends Exception {

    public String getAbsoluteFilePath(String relativeFilePath) {
        return Paths.get(relativeFilePath).toAbsolutePath().toString();
    }

    public String readAllBytesFromTextFile(String absoluteFilePath){
        String contentFromTextFile = "";

        try
        {
            contentFromTextFile = new String (Files.readAllBytes(Paths.get(absoluteFilePath)));
        }
        catch (IOException e)
        {
            System.out.print("Wrong file path specified! ");
            e.printStackTrace();
        }

        return contentFromTextFile;
    }

    public Deque<String> getStringLinesFromFile(String initialStringFile) {
        String[] lines = initialStringFile.split("\n");
        Deque<String> stringLinesDequeContainer = new ArrayDeque<>();

        for (String stringArrayValue : lines) {
            stringLinesDequeContainer.push(stringArrayValue.replace("\r", ""));
        }

        return stringLinesDequeContainer;
    }

    public void writeDequeContentToTextFile(Deque<String> initialDeque, String relativeFilePath) throws IOException {
        List<String> reversedLines = new ArrayList<>(initialDeque);
        Path reversedFilePath = Files.createFile(Paths.get(relativeFilePath).toAbsolutePath());
        Files.write(reversedFilePath, reversedLines, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws IOException {
        ReadAndWriteWithReverseTextFileHelper readAndWriteWithReverseTextFileHelperItem = new ReadAndWriteWithReverseTextFileHelper();

        String absoluteFilePath = readAndWriteWithReverseTextFileHelperItem.getAbsoluteFilePath("src\\main\\java\\javacollections\\optionaltasks\\firsttask\\NumbFirstPart.txt");
        String stringsFromFile = readAndWriteWithReverseTextFileHelperItem.readAllBytesFromTextFile(absoluteFilePath);
        Deque<String> dequeLinesContainer = readAndWriteWithReverseTextFileHelperItem.getStringLinesFromFile(stringsFromFile);
        readAndWriteWithReverseTextFileHelperItem.writeDequeContentToTextFile(dequeLinesContainer, "src\\main\\java\\javacollections\\optionaltasks\\firsttask\\ReversedNumbFirstPart.txt");
    }
}
