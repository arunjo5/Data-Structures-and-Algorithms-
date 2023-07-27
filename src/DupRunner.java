import static java.lang.System.*;
import java.util.*;
public class DupRunner {
    public static void main(String args[])
    {
    System.out.println(UniquesDupes.getUniques("a b c d e f g h a b c d e f g h i j k"));
        System.out.println(UniquesDupes.getDupes("a b c d e f g h a b c d e f g h i j k" ));

        System.out.println(UniquesDupes.getUniques("one two three one two three six seven one two"));
        System.out.println(UniquesDupes.getDupes("one two three one two three six seven one two"));

    }
}