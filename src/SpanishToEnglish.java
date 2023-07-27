import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanishToEnglish
{
    private Map<String,String> pairs;

    public SpanishToEnglish()
    {
    pairs = new TreeMap<>();
    }

    public void putEntry(String entry)
    {
        String[] list = entry.split(" ");
      for (int x=0; x<list.length; x+=2) {
          for (int y=1; y<list.length; y+=2)
          pairs.put(list[x],list[y]);
      }
    }

    public String translate(String sent)
    {
        Scanner chop = new Scanner(sent);
        String output = "";
        while(chop.hasNext()){
            output += " " + pairs.get(chop.next());
        }
        return output;
    }


    public String toString()
    {
        return pairs.toString().replaceAll("\\,","\n");
    }
}