import java.util.*;
import java.io.*;
public class WordCounter {
        HashMap<String,Integer> map = new HashMap<>();

        public void add(String line){
            String[]words = line.replaceAll("\\p{Punct}","").toLowerCase().split(" ");
            for (String s : words){
                if (map.containsKey(s)) {
                    map.replace(s,map.get(s)+1);
                }
                else {
                map.put(s,1);
            }
        }
        }
        public void print() {
        for (String s: map.keySet()) {
            System.out.println("Word: " + s + " Occurrences: " + map.get(s));
        }
        }

        public void other(){
            HashSet<String> three = new HashSet<>();
        for (String s: map.keySet()) {
            if (map.get(s) == 3) {
                three.add(s);
            }
        }
        int most = Integer.MIN_VALUE;
        for (String s: map.keySet()) {
            if (map.get(s) > most) {
                most = map.get(s);
            }
        }
        System.out.print("Three times: " + three + " Most: " + most);
        }

    public static void main(String[]args) throws IOException {
            WordCounter test = new WordCounter();
            Scanner file = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/words.dat"));
            while (file.hasNextLine()) {
                test.add(file.nextLine());
            }
            test.print();
            test.other();
    }
}
