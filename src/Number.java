public class Number
{
    private int theValue;

    public Number(int value)
    {
        theValue = value;

    }

    public int getValue()
    {
        return theValue;
    }

    public boolean equals(Object obj) {
        Number other = (Number) obj;
        return theValue == other.getValue();
    }

    public int hashCode()
    {
        return theValue % 10;
        // based on the output, and specificially on how bucket indices relate to each number in the bucket,
        // implement sa proper hashcode
    }

    public String toString()
    {
        return "" + theValue;
    }
}