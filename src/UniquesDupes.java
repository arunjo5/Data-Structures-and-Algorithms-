import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes
{
    public static Set<String> getUniques(String input)
    {
        Set<String> uniques = new TreeSet<String>();
        String[]list = input.split(" ");
        for (String s : list) {
            uniques.add(s);
        }

        return uniques;
    }

    public static Set<String> getDupes(String input)
    {
        Set<String> dupes = new TreeSet<String>();
        Set<String> realdupe = new TreeSet<String>();

        String[]list = input.split(" ");
        for (String s : list) {
           if (dupes.add(s) == false) {
               realdupe.add(s);
           }
        }

        return realdupe;
    }
}