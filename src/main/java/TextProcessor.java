import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextProcessor {

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void printOccurencesOfEveryWord(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    public Map getOccurrenceMap() {
        File text = new File("src/main/resources/files/" + file);
        try {
            Scanner sc = new Scanner(text);
            Map<String, Integer> map = new HashMap<>();
            while(sc.hasNext()) {
                String word = sc.next();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int numOfChars() {
        File text = new File("src/main/resources/files/" + file);
        try {
            Scanner sc = new Scanner(text);
            StringBuilder sb = new StringBuilder();
            while(sc.hasNext()) {
                sb.append(sc.next());
            }
            return sb.toString().length();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int numOfWords() {
        File text = new File("src/main/resources/files/" + file);
        try {
            Scanner sc = new Scanner(text);
            int count = 0;

            while(sc.hasNext()) {
                count++;
                sc.next();
            }
            return count;
        }   catch (IOException e) {
        e.printStackTrace();
        }
        return -1;
    }

    public void mostWrittenWord(Map<String, Integer> map, int reps) {
        System.out.println("Words with " + reps + " or more occurrences!");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > reps) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

    }
}
