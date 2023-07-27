import java.util.Stack;

public class three_probset {
    public void digits(int x) {
        Stack<Integer> num = new Stack<Integer>();
        while (x > 0) {
            num.push(x % 10);
            x = x / 10;
        }
        while (!num.isEmpty()) {
        System.out.print(num.pop() + " ");
        }
    }
    public void reversesentence(String s) {
    Stack<String> sentence = new Stack<String>();


    }
    public static void main(String[]args) {
        three_probset s = new three_probset();
        s.digits(1729);
    }
}
