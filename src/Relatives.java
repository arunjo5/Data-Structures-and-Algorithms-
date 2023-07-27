import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class Relatives {
    private Map<String, Set<String>> map;

    public Relatives() {
        map = new TreeMap<>();
    }

    public void setPersonRelative(String line) {
        String[] personRelative = line.split(" ");

        // Update map with the relationship in both directions
        String person = personRelative[0];
        String relative = personRelative[1];

        Set<String> relatives = map.get(person);
        if (relatives == null) {
            relatives = new TreeSet<String>();
            map.put(person, relatives);
        }
        relatives.add(relative);

        relatives = map.get(relative);
        if (relatives == null) {
            relatives = new TreeSet<String>();
            map.put(relative, relatives);
        }
        relatives.add(person);
    }

    public String getRelatives(String person) {
        Set<String> relatives = map.get(person);
        if (relatives == null) {
            return "";
        } else {
            return String.join(" ", relatives);
        }
    }

    public String toString() {
        String output = "";
        for (String person : map.keySet()) {
            Set<String> relatives = map.get(person);
            output += person + " is related to " + String.join(" ", relatives) + "\n";
        }
        return output;
    }
}