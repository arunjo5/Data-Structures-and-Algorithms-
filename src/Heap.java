import java.util.*;
import static java.lang.System.*;

public class Heap
{
    private ArrayList<Integer> list;

    public Heap()
    {
        list = new ArrayList<Integer>();
    }

    public void add(int value)
    {
    list.add(value);

    }

    public void swapUp(int bottom)
    {
        int parent = list.get(bottom) / 2;
        if (bottom > parent) {
            swap(bottom,parent);
        }
    }

    public void remove( )
    {
    
    }

    public void swapDown(int top)
    {
    }

    private void swap(int start, int finish)
    {
    }

    public void print()
    {
        out.println("\n\nPRINTING THE HEAP!\n\n");
        out.println();
    }

    public String toString()
    {
        return list.toString();
    }
}