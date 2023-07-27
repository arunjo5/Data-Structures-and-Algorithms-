import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AcroRunner {
    public static void main(String args[]) throws IOException {
        Scanner file = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/acro.dat"));
        int numAcronyms = Integer.parseInt(file.nextLine());

        Acronyms acronyms = new Acronyms();

        for (int i = 0; i < numAcronyms; i++) {
            String entry = file.nextLine();
            acronyms.putEntry(entry);
        }

        System.out.println("==== MAP CONTENTS ====");
        System.out.println(acronyms);

        System.out.println("==== READ LINES ====");
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String converted = acronyms.convert(line);
            System.out.println(converted);
        }
    }
}
