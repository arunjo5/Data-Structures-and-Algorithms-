 public class count11 {


     public static int pow (int base, int exponent) {
       if (exponent ==0) {
        return 1;
       }
        return base * pow(base, exponent-1);
     }


public static void main(String[]args) {
         count11 x = new count11();
         System.out.println(x.pow(5,3));
}



 }