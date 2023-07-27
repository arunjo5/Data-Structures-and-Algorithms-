import java.util.Stack;

public class StackTest
{
    private Stack<String> stack;

    public StackTest() {
    stack = new Stack<String>();
    }

    public StackTest(String line) {
    setStack(line);
    }

    public void setStack(String line) {
        stack = new Stack<String>();
        String[]list = line.split(" ");
        for (String s: list) {
            stack.push(s);
        }
    }

    public void popEmAll() {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public String toString() {
        String blank = "";
        for (String s : stack) {
            blank += s + "";
        }
        return blank;
    }
}