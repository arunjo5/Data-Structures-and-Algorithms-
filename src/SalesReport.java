import java.util.*;
import java.io.*;
public class SalesReport {
    HashMap<String, Double> map = new HashMap<>();

    public void add(String line){
    String[]words = line.split(",");
    String category = words[1];
    double value = Double.parseDouble(words[2]) * (Double.parseDouble(words[3]));
        if (map.containsKey(category))  {
                map.put(category,map.get(category) + value);
            }
        else {
            map.put(category,value);
        }
    }

    public void print(){
    for (String s: map.keySet()) {
        System.out.print("Total sales revenue for " + s + " : " + map.get(s) + "\n");
    }
    }

    public static void main(String[]args) throws IOException {
    SalesReport test = new SalesReport();
    Scanner file = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/SalesReport.dat"));
    while (file.hasNextLine()){
        test.add(file.nextLine());
    }
    test.print();
    }
}
