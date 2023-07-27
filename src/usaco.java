import java.util.*;

public class usaco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] inputs = new int[m][n];
            int[] outputs = new int[m];
            for (int j = 0; j < m; j++) {
                String input = sc.next();
                for (int k = 0; k < n; k++) {
                    inputs[j][k] = input.charAt(k) - '0';
                }
                outputs[j] = sc.nextInt();
            }
            boolean isLie = checkLie(inputs, outputs, n);
            if (isLie) {
                System.out.println("LIE");
            } else {
                System.out.println("OK");
            }
        }
    }
    public static boolean checkLie(int[][] inputs, int[] outputs, int n) {
        for (int i = 0; i < n; i++) {
            int[] temp = new int[inputs.length];
            for (int j = 0; j < inputs.length; j++) {
                temp[j] = inputs[j][i];
            }
            if (!check(temp, outputs)) {
                return false;
            }
        }
        return true;
    }

    public static boolean check(int[] input, int[] output) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        int zeroOutput = 0;
        int oneOutput = 0;
        for (int i = 0; i < output.length; i++) {
            if (input[i] == 0 && output[i] == 0) {
                zeroOutput++;
            } else if (input[i] == 1 && output[i] == 1) {
                oneOutput++;
            }
        }
        if (zeroOutput == zeroCount && oneOutput == oneCount) {
            return true;
        }
        return false;
    }

}