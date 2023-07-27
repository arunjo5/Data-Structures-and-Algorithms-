import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpanRunner {
    public static void main(String[] args) throws IOException {
        SpanishToEnglish s = new SpanishToEnglish();
        Scanner scanner = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/spantoeng.dat"));
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            s.putEntry(scanner.nextLine());
        }

        System.out.println("==== MAP CONTENTS ====");
        System.out.println(s);

        while (scanner.hasNextLine()) {
            String sentence = scanner.nextLine();
            String translation = s.translate(sentence);
            System.out.println(translation);
        }

        scanner.close();
    }
}
