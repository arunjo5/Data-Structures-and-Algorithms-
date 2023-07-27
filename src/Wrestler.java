import java.util.Objects;

public class Wrestler
{
    private String name;
    private int weight;

    public Wrestler( String theName, int theWeight)
    {
        name= theName;
        weight=theWeight;
    }
    public int getWeight()
    {
        return weight;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrestler wrestler = (Wrestler) o;
        return weight == wrestler.weight && Objects.equals(name, wrestler.name);
    }

    public int hashCode() {
        return weight % 10;
    }
}