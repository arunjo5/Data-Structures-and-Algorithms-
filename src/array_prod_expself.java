import java.util.Arrays;
public class array_prod_expself {

    public String arrayprod(int[] arr) {
        // O(n^2) solution
        int[]copy = new int[arr.length];
    int prod =1;
    for (int x=0; x<arr.length;x++) {
        prod *= arr[x]; // 48
    }
    for (int y=0; y<arr.length;y++) {
        copy[y] = prod/(arr[y]); // copy[0] = 48/(1+1)
    }
        return Arrays.toString(copy);
    }
    public static void main(String[]args) {
        array_prod_expself test = new array_prod_expself();
        System.out.println(test.arrayprod(new int[]{1,2,3,4}));

    }
}
