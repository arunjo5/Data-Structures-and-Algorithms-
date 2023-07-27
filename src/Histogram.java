import java.util.Map;
import java.util.TreeMap;

public class Histogram
{
    private Map<String,Integer> histogram;

    public Histogram()
    {
        histogram = new TreeMap<>();
    }

    public Histogram(String sent)
    {
        String[]nums = sent.split(" ");
        int ct=0;
        for (String s : nums) {
            histogram.put(s,null);
        }


    }

    public void setSentence(String sent)
    {
        String[]nums = sent.split(" ");

    }

    public String toString()
    {
        String output="";
        String allStars="";
        return output+"\n\n";
    }
}