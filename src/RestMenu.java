import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestMenu {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/user/IdeaProjects/AT CS/src/CountryPlaceMenu.dat"));
        Rest r = new Rest();
        while (scanner.hasNextLine()) {
            r.add(scanner.nextLine());
        }
        System.out.println("Entire Map:\n" + r.toString());
        System.out.println("Menu Items with exactly two words: " + r.twowords().toString());
        System.out.print("Menu Items that contain cheese: ");
        r.cheese();
    }


    }