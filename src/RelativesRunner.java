import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner {
    public static void main(String args[]) throws IOException {
        Relatives r = new Relatives();
        Scanner scanner = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/relatives.dat"));
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            r.setPersonRelative(scanner.nextLine());
        }

        // print out the list of relatives for each person
        System.out.println(r.toString());

        // print out the relatives for Dot as an example
       // System.out.println("Dot is related to " + r.getRelatives("Dot"));
    }
}