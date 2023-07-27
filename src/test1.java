import java.util.Arrays;

public class test1 {
    // (recursion) return an integer of the factorial of a number with the multiples of 5 turned into a 1
    public int factorial(int n) {
        if (n < 2) {return 1;}

    if (n < 5) {
        return n * factorial(n-1);
    }
    else if (n % 5==0) {
        return 1 * factorial(n-1);
    }
    return n * factorial(n-1);
    }

    // (recursion) return an integer representing the number of times the number 44 appears in an array
    public int num(int[]arr, int n) {
        int count=0;
        if (arr.length < 1) {return 0;}
        int[]temp = new int[arr.length-1];
        if (n == arr[0]) {
            count=1;
        }
        for (int x=1; x< arr.length;x++) {
            temp[x-1] = arr[x];
        }
        return count + num(temp, n);
    }

    // 1st test ; problem 2
    public static boolean addTen(int value) {
        if (addInt(value) == 10) {
            return true;
        }
        return false;
    }
    public static int addInt(int value) {
        if (value < 10) {
            return value;
        }
        return value%10 + addInt(value/10);
    }

    public int rainbowpairs(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        if (s.charAt(0) == (s.charAt(s.length()-1))) {
            return 1 + rainbowpairs(s.substring(1, s.length()-1));
        }
        return rainbowpairs(s.substring(1, s.length()-1));
    }



    public static boolean almostPalindrome(String s) {
        if (s.length() == 2 || s.length() ==3) {
            return true;
        }
        if ((almostP(s) == s.length()/2) || (almostP(s) == (s.length()/2)-1)) {
            return true;
        }
        else  {
            return false;
        }

    }
    public static int almostP(String s) {
        if (s.length() == 1) {
            return 0;
        }
        if (s.charAt(0) == s.charAt(s.length()-1)) {
            return 1 + almostP(s.substring(1,s.length()-1));
        }
        return almostP(s.substring(1,s.length()-1));
    }

    public static void main(String[]args) {
    test1 t = new test1();
    int[]arr = {51,44,51,98,51,51};
   // System.out.println(t.factorial(5));
   // System.out.println(t.num(arr,51));
    //    System.out.println(addTen(411202));
    //    System.out.println(addTen(3639));
     //   System.out.println(t.rainbowpairs("hello")); // 2
        System.out.print(almostPalindrome("bobol"));
    }
}
