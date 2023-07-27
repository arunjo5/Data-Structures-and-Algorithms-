import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueMethods {

    // Returns a new queue that is the clone of one.
    public static Queue<String> clone(Queue<String> one) {
    Queue<String>clones = new LinkedList<>();
    for (String s : one) {
        clones.add(s);
    }
    return clones;
    }
    // Try a different approach to clone (hint: one is longer, one is short)
    public static Queue<String> clone2(Queue<String> one) {
    return new LinkedList<String>(one);
    }

    // Returns a new Queue that is the reverse of one.
    public static Queue<String> reverse(Queue<String> x) {
    Queue<String>queue = new LinkedList<>();
    Stack<String>stack = new Stack<>();
    for (String s : x) {
        stack.push(s);
    }
    while (!stack.isEmpty()) {
      queue.add(stack.pop());
    }
    return queue;
    }

    // add Queue y to the end of Queue x. Return the new queue
    public static Queue<String> append(Queue<String> x, Queue<String> y) {
        Queue<String> extend = new LinkedList<>();
        for (String s : x) {
            extend.add(s);
        }
        for (String s : y) {
            extend.add(s);
        }
        return extend;
    }

    // Return a new queue with alternating values from one and two
    public static Queue<String> alternate(Queue<String> one, Queue<String> two) {
    Queue<String>queue = new LinkedList<>();
    while (!one.isEmpty()) {
        queue.add(one.remove());
        queue.add(two.remove());
    }
    return queue;
    }

    // Determines if a queue of strings is a palindrome. Return True/False
    public static boolean isPalindrome(Queue<String> x) {
        Stack<String>stack = new Stack<>();
        for (String s : x) {
            stack.push(s);
        }
        while (!x.isEmpty()) {
            if (!stack.peek().equals(x.element())) {
                return false;
            }
            stack.pop();
            x.remove();
        }
        return true;
    }
    // Try a different approach to palindrome (hint: one is longer, one is short)
    public static boolean isPalindrome2(Queue<String> x) {
    return true;
    }

    // Determines if a queue of strings are in alphanumeric order. Return True/False
    public static boolean isAlphabetical(Queue<String> x) {
        while (!x.isEmpty()) {
            String num1 = String.valueOf(x.remove());
            String num2 = String.valueOf(x.remove());
            if (num1.compareTo(num2) > 0) {
                return false;
            }
        }
        return true;
    }

    // Calculates the average of a queue of integers.
    public static double average(Queue<Integer> x) {
    int sum=0;
    for (Integer i : x) {
        sum += i;
    }
    return sum / x.size();
    }

    // Determines whether string lookFor is in the Queue lookIn . Return True/False
    public static boolean search(String lookFor, Queue<String> lookIn) {
        while (!lookIn.isEmpty()) {
            if (lookIn.remove().equals(lookFor)) {
                return true;
            }
        }
        return false;
    }

    // remove all of the occurrences of lookFor in Queue lookIn
    public static Queue<String> remove(String lookFor, Queue<String> lookIn) {
        Queue<String>queue = new LinkedList<>();
        for (String s : lookIn) {
            if (!s.equals(lookFor))  {
                queue.add(s);
            }
        }
        return queue;
    }

    // Remove every other element of one starting with the first
    public static Queue<String> removeEveryOther(Queue<String> one) {
    Queue<String> queue = new LinkedList<>();
    int index=0;
    for (String s: one) {
        if (index %2 != 0) {
            queue.add(s);
        }
        index++;
    }
    return queue;
    }

    // return a string of the first n binary numbers.... 1 10 11 100 101 110 111
    // 1000...
    public static String generateBinary(int n) {
    Queue<String> queue = new LinkedList<>();
    return "";

    }

    public static void main(String[] args) {

        Queue<String> one = new LinkedList<String>();

        one.offer("A");
        one.offer("B");
        one.offer("C");
        one.offer("D");
        one.offer("E");
        one.offer("Z");
        System.out.println("COPY: " + clone2(one));
        System.out.println("ONE: " + one);
        System.out.println("REMOVE EVERY OTHER:" + removeEveryOther(one));
        System.out.println("REVERSE:" + reverse(one));
        System.out.println("SEARCH for E:" + search("E", one));
        System.out.println("SEARCH for Q:" + search("Q", one));
        Queue<String> two = new LinkedList<String>();
        two.offer("1");
        two.offer("2");
        two.offer("2");
        two.offer("1");
         one = new LinkedList<String>();


        System.out.println("TWO: " + two);
        System.out.println("APPEND " + append(one, two));
        System.out.println("REMOVE 1: " + remove("1", two));
        System.out.println("TWO: " + two);
        System.out.println("REMOVE 7: " + remove("7", two));
        System.out.println("TWO: " + two);
        System.out.println("COPY: " + clone2(one));
        System.out.println("ALTERNATE: " + alternate(one, two));
        System.out.println("ONE: " + one);
        System.out.println("TWO: " + two);
        System.out.println("ISPALINDROME ONE? " + isPalindrome(one));
        System.out.println("ISPALINDROME TWO? " + isPalindrome(two));
        System.out.println("ISALPHABETICAL ONE? " + isAlphabetical(one));
        System.out.println("ISALPHABETICAL TWO? " + isAlphabetical(two));
        System.out.println(isPalindrome2(one));
        System.out.println(reverse(one));
        System.out.println(one);
        Queue<Integer> three = new LinkedList<Integer>();
        three.offer(11);
        three.offer(12);
        three.offer(2);
        three.offer(71);
        System.out.println("AVERAGE: " + average(three));
        System.out.println("THREE: " + three);
        System.out.println(generateBinary(16));
    }

}