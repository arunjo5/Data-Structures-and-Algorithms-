import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HashTableRunner {
    public static void main(String[] args) throws IOException {
        HashTable table = new HashTable(10);
        Scanner file = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/words.dat"));
        int numWords = file.nextInt();
        file.nextLine(); // consume newline
        for (int i = 0; i < numWords; i++) {
            String wordStr = file.nextLine();
            Word word = new Word(wordStr);
            table.add(word);
        }
        file.close();
        System.out.println(table);
    }
}
