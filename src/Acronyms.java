import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Acronyms {
    private Map<String, String> acronymTable;

    public Acronyms() {
        acronymTable = new HashMap<String, String>();
    }

    public void putEntry(String entry) {
        String[] parts = entry.split(" - ");
        acronymTable.put(parts[0], parts[1]);
    }

    public String convert(String sent) {
        Scanner chop = new Scanner(sent);
        String output = "";

        while (chop.hasNext()) {
            String word = chop.next();
            if (acronymTable.containsKey(word)) {
                output += acronymTable.get(word) + " ";
            } else {
                output += word + " ";
            }
        }

        return output.trim();
    }


    public String toString() {
        return acronymTable.toString();
    }
}
