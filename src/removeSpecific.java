import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class removeSpecific {
    HashMap<Integer,Integer> map;
    public removeSpecific() {
        map = new HashMap<>();
    }
    public void add (String line) {
        String[]list = line.split(" ");
        int ct=1;
        for (String s: list) {
            map.put(ct, Integer.valueOf(s));
            ct++;
        }
    }
    public void remove (Integer i) {
        Set<Integer> set= new HashSet<>();
        for (int num : map.keySet()) {
            if (i.equals(map.get(num))) {
                set.add(num);
            }
        }
        for (int num: set) {
            map.remove(num);
        }
    }
    public String toString() {
        String s = "";
        for (Integer x : map.keySet()) {
            s += map.get(x) + " ";
        }
        return s;
    }
        public static void main(String[] args) {
    removeSpecific r = new removeSpecific();
    r.add("1 5 3 5 9 0 7 2 5");
    System.out.println(r.toString());
    r.remove(5);
    System.out.println(r.toString());

    }
}
