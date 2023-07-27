public class StackTestRunner {
        public static void main (String[] args) {
            String[] testCases = { "a b c d e f g h i", "1 2 3 4 5 6 7 8 9 10", "# $ % ^ * ( ) ) _" };
            for (String testCase : testCases) {
                StackTest tester = new StackTest(testCase);
                System.out.println(tester);
                System.out.print("popping all items from the stack: ");
                tester.popEmAll();
                System.out.println();
            }
        }
    }

