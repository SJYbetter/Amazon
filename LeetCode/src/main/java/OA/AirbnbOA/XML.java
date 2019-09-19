package OA.AirbnbOA;

import java.util.Stack;

public class XML {
    public static String xmlValidor(String s){
        //return "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (cur == '<') {
                boolean close = false;
                int index = i + 1;
                if (index < s.length() && s.charAt(index) == '/') {
                    close = true;
                    index++;
                }
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && s.charAt(index) != '>') {
                    sb.append(s.charAt(index));
                    index++;
                }

                if (index >= s.length()) return "close error";

                if (validTagName(sb.toString())) {
                    if (close) {
                        if (!stack.isEmpty()) {
                            String pre = stack.pop();
                            if (!pre.equals(sb.toString())) return "close error";
                        } else {
                            return "close error";
                        }
                    } else stack.push(sb.toString());
                } else {
                    return "parse error";
                }

                i = index;

            }

        }

        if (!stack.isEmpty()) return "close error";

        return "true";
    }

    private static boolean validTagName(String s){
        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '<' || s.charAt(i) == '>' || s.charAt(i) == '/') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "<a>text</a>";
        String test2 = "<a><b>text</b></a>";
        String test3 = "<a><b>text</a></b>";
        String test4 = "<a><b<>text</b></b>";
        String test5 = "<a>asdfasdf";

        System.out.println(xmlValidor(test));
        System.out.println(xmlValidor(test2));
        System.out.println(xmlValidor(test3));
        System.out.println(xmlValidor(test4));
        System.out.println(xmlValidor(test5));
    }
}
