public class Person implements Comparable<Person> {
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

    public int compareTo(Person other) {
        int result = this.lastName.compareTo(other.lastName);
        if (result == 0) {
            result = this.firstName.compareTo(other.firstName);
        }
        return result;
    }
}