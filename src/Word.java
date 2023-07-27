import java.util.HashMap;
import java.util.HashSet;

public class Word
{
    private String theValue;

    public Word(String value) {
        theValue = value;
    }
    //write a constructor method


    public String getValue() {
    return theValue;
    }
    //write the getValue method


    public boolean equals(Object other) {
    if (other instanceof Word) {
        Word otherW = (Word) other;
        return theValue.equals(otherW.getValue());
    }
    return false;
    }
    //write the equals method


    public int hashCode() {
    HashSet<Character> set = new HashSet<>();
    set.add('a');     set.add('e');     set.add('i');     set.add('o');     set.add('u');
    set.add('A');     set.add('E');     set.add('I');     set.add('O');     set.add('U');
        int ct=0;
    String word = getValue();
    for (int x=0; x<word.length(); x++) {
        if (set.contains(word.charAt(x))) {
            ct ++;
        }
    }
    return (word.length() * ct) % 10;
    }
    //write the hashCode method


    public String toString() {
    return theValue;
    }
    //write the toString method


}