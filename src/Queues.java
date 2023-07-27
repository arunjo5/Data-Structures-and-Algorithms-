import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues {

    public static int largest(Queue<Integer> nums){
        int x = Integer.MIN_VALUE;
        while (!nums.isEmpty()){
        if (nums.peek() > x) {
        x = (nums.peek());
        nums.remove();
        }
        nums.remove();
        }
        return x;
    }
    public static void reverse (Queue<Integer>nums){
        Stack<Integer> stack = new Stack<>();
        for (Integer x : nums) {
            stack.push(x);
        }
        System.out.print("The reversed queue is: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


    public static void main(String[]args) {
        Queue<Integer> nums  = new LinkedList<>();
        nums.add(3);
        nums.add(7);
        nums.add(12);
        nums.add(8);
        System.out.println("The largest element in the queue is: " + largest(nums));
        Queue<Integer> nums2  = new LinkedList<>();
        nums2.add(3);
        nums2.add(7);
        nums2.add(12);
        nums2.add(8);
        reverse(nums2);


    }


}
