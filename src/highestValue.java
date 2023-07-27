import java.util.HashMap;
import static java.lang.System.out;

public class highestValue {

    HashMap<Integer, String> map;

    public highestValue() {
        map = new HashMap<>();
    }

    public void populate(String list) {
        String[] nums = list.split(" ");

        int ct = 0;
        for (String x : nums) {
            map.put(ct, x);
            ct++;
        }
    }

    public int highest() {
        int highestValue = Integer.MIN_VALUE;
        for (String value : map.values()) {
            int currentValue = Integer.parseInt(value);
            if (currentValue > highestValue) {
                highestValue = currentValue;
            }
        }
        return highestValue;
    }

    public static void main(String[] args) {
        highestValue h = new highestValue();
        h.populate("2 4 10 1 84 43 51 90 12 5 6");
        out.println(h.highest());
    }
}
