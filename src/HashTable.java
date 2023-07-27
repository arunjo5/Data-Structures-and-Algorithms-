import java.util.LinkedList;

public class HashTable {

    private LinkedList<Word>[] table;

    public HashTable(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<Word>();
        }
    }

    public void add(Word word) {
        int index = word.hashCode() % table.length;
        LinkedList<Word> list = table[index];
        if (!list.contains(word)) {
            list.add(word);
        }
    }


    public String toString() {
        String output = "HASHTABLE\n";
        for (int i = 0; i < table.length; i++) {
            output += "bucket " + i + " - ";
            LinkedList<Word> list = table[i];
            for (Word word : list) {
                output += word.getValue() + " ";
            }
            output += "\n";
        }
        return output;
    }
}
