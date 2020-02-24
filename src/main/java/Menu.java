import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private TextProcessor tp = new TextProcessor();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        tp.setFile(chooseFile());
            while(true) {
            System.out.println(
                    "Current file: " + tp.getFile() + "\n" +
                    "(1) Number of words\n" +
                    "(2) Number of characters\n" +
                    "(3) Occurrences of every word\n" +
                    "(4) Most written words\n" +
                    "(5) Change file\n" +
                    "(Q) Quit"
            );
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("The file contains " + tp.numOfWords() + " words!");
                    break;
                case "2":
                    System.out.println("The file contains " + tp.numOfChars() + " characters");
                    break;
                case "3":
                    tp.printOccurencesOfEveryWord(tp.getOccurrenceMap());
                    break;
                case "4":
                    System.out.println("Enter how many occurrences the words must have");
                    int occurrences = sc.nextInt(); sc.nextLine();
                    tp.mostWrittenWord(tp.getOccurrenceMap(), occurrences);
                    break;
                case "5":
                    tp.setFile(chooseFile());
                    break;
                case "Q":
                    System.exit(1);
                    break;
            }
        }
    }

    private List<String> generateFileList() {
        List<String> results = new ArrayList<>();

        File[] files = new File("src/main/resources/files").listFiles();

        //If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        return results;
    }

    private String chooseFile() {
        int count = 1;
        System.out.println("Choose file you want examined");
        for(String file : generateFileList()) {
            System.out.println("(" + count + ") " + file);
            count++;
        }
        int fileIndex = sc.nextInt(); sc.nextLine();
        return findFile(fileIndex);
    }

    private String findFile(int fileIndex) {
        return generateFileList().get(fileIndex - 1);
    }
}
