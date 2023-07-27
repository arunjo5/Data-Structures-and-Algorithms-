import java.io.*;
import java.util.*;

public class TomSawyer {
        HashMap<String, Integer> map = new HashMap<>();

    public void add(String line) {
    String[]words = line.replaceAll("\\p{Punct}","").toLowerCase().split(" ");
    Set<String> set = new HashSet<>();
        int ct=1;
        for (String s: words) {
        if (set.add(s) == false) {
            ct++;
        }
        map.put(s,ct);
    }
    }
    public void times() {
        Set<String> once = new HashSet<>();
        Set<String> ten = new HashSet<>();

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                once.add(s);
            }
            else if (map.get(s) >=10) {
                ten.add(s);
            }
        }
        System.out.print("One times: " + once + "\nMore than 10 times: " + ten);
    }

    public void print(){
    for (String s: map.keySet()){
        System.out.println("Word: " + s + "   Count: " + map.get(s));
    }
    }

    public static void main(String[]args) throws IOException {
    TomSawyer test = new TomSawyer();
    Scanner file = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/tomSawyer.txt"));
    while (file.hasNextLine()) {
        test.add(file.nextLine());
    }
    test.print();
    test.times();

    }
}
