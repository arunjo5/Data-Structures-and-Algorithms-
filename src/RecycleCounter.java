import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RecycleCounter {
    private Map<String, SodaCounts> map;

    public RecycleCounter() {
        map = new TreeMap<String, SodaCounts>();
    }

    public void add(String line) {
        String[] tokens = line.split(" ");
        for (int i = 1; i < tokens.length; i++) {
            String[] itemTokens = tokens[i].split("-");
            String container = itemTokens[1];
            String flavor = itemTokens[0];
            SodaCounts sodaCounts = map.get(container);
            if (sodaCounts == null) {
                sodaCounts = new SodaCounts();
            }
            if (flavor.equals(sodaCounts.getSoda1())) {
                sodaCounts.setSodCt1(sodaCounts.getSodCt1() + 1);
            } else if (flavor.equals(sodaCounts.getSoda2())) {
                sodaCounts.setSodCt2(sodaCounts.getSodCt2() + 1);
            } else if (flavor.equals(sodaCounts.getSoda3())) {
                sodaCounts.setSodCt3(sodaCounts.getSodCt3() + 1);
            }
            map.put(flavor, sodaCounts);
        }
    }

    public void print() {

        for (String s : map.keySet()) {
            System.out.print(s + " " + map.get(s));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        RecycleCounter test = new RecycleCounter();
        Scanner file = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/sodaCollecting.dat"));

        while (file.hasNextLine()) {
        test.add(file.nextLine());
    }
    test.print();
    }
}