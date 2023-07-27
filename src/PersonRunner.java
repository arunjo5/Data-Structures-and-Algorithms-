import java.util.Comparator;
import java.util.TreeSet;

public class PersonRunner {

    static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String toString() {
            return "Name: " + firstName + " " + lastName;
        }
    }

    static class PersonComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            int result = p1.getLastName().compareTo(p2.getLastName());
            if (result == 0) {
                result = p1.getFirstName().compareTo(p2.getFirstName());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeSet<Person> mySet = new TreeSet<Person>(new PersonComparator());
        mySet.add(new Person("Sally", "Brown"));
        mySet.add(new Person("Fred", "Kelly"));
        mySet.add(new Person("Bill", "Akins"));
        mySet.add(new Person("Julie","Wilkins"));
        mySet.add(new Person("James", "Langdon"));
        for (Person p : mySet) {
            System.out.println(p);
        }
    }
}
