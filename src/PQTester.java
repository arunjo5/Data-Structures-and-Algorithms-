import java.util.PriorityQueue;
import java.util.Queue;

public class PQTester
{
    private Queue<String> pQueue;

    public PQTester() {
        pQueue = new PriorityQueue<>();
    }

    public PQTester(String list)
    {
        pQueue = new PriorityQueue<>();
        setPQ(list);
    }

    public void setPQ(String list)
    {
        String[] split = list.split(" ");
        for (String s : split) {
            pQueue.add(s);
        }
    }

    public Object getMin()
    {
        return pQueue.peek();
    }

    public String getNaturalOrder()
    {
        String s = "";
        PriorityQueue<String>copy = new PriorityQueue<>(pQueue);
        while (!copy.isEmpty()) {
            s += copy.poll() + " ";
        }
        return s;

    }

    public String toString() {
        return pQueue.toString();
    }
}