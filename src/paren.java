public class paren {

    public String parenBit(String str) {
        if (str.equals("()")) {
            return "()";
        }
        String s = "";
        if (str.charAt(0) != '(' ) {
            s += str.substring(1);
            return parenBit(s);
        }
        if (str.charAt(0) != ')') {
            s += str.substring(1);
            return str.charAt(0) + parenBit(s);
        }
        s += str.substring(1);
        return parenBit(s);
    }

}
