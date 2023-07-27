import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Rest {
        Map<String, ArrayList<String>> map;

        public Rest() {
                map = new HashMap<>();
        }

public void add(String line) {
        String[] parts = line.split(" ");
        String category = parts[0];
        String foodItem = parts[1] + " " + parts[2];

        ArrayList<String> items = map.getOrDefault(category, new ArrayList<String>());
        items.add(foodItem);
        map.put(category, items);
        }

public String toString() {
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        return "";
        }

public Set<String> twowords() {
        Set<String> result = new HashSet<>();
        for (ArrayList<String> items : map.values()) {
        for (String item : items) {
        if (item.split(" ").length == 2) {
        result.add(item);
        }
        }
        }
        return result;
        }

public Set<String> cheese() {
        Set<String> result = new HashSet<>();
        for (ArrayList<String> items : map.values()) {
        for (String item : items) {
        if (item.toLowerCase().contains("cheese")) {
        result.add(item);
        }
        }
        }
        System.out.println(result.toString());
        return result;
        }
}