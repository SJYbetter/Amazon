package OA.AirbnbOA;

import java.util.ArrayList;

public class Divider {
    public static String division(int a, int b){
        /*int flag = 0;
        if (a1 > 0 && b1 < 0 || a1 < 0 && b1 > 0) {
            flag = 1;
        }
        int a = Math.abs(a1);
        int b = Math.abs(b1);
        */


        StringBuffer sb = new StringBuffer();
        sb.append(a / b);
        int remainder = a % b;
        if (remainder == 0){
            return sb.toString();
        }
        sb.append('.');

        ArrayList<Integer> decimals = new ArrayList<>();
        ArrayList<Integer> remainders = new ArrayList<>();

        boolean match_all = false;
        int length = 0, start = 0;

        remainders.add(remainder);
        while (remainder != 0) {
            remainder = remainder * 10;
            decimals.add(remainder / b);
            remainder = remainder % b;

            int pos = remainders.lastIndexOf(remainder);  // check loop
            if (pos != -1) {
                length = remainders.size() - pos;
                start = pos - length + 1;
                if (start >= 0) {
                    match_all = true;
                    for (int y = length - 1 - 1; y >= 0; y--) {  // length -1 already check on lastIndexOf
                        match_all &= (pos + 1 + y < remainders.size() && remainders.get(start + y).equals(remainders.get(pos + 1 + y)));
                    }
                    if (match_all)
                        break;
                }
            }
            remainders.add(remainder);
        }

        if (match_all) {
            for (int y = 0; y < start + length; y++) {
                if (y == start) {
                    sb.append('(');
                }
                sb.append(decimals.get(y));
            }
            sb.append(')');
        }else{
            for(int y=0;y<decimals.size();y++){
                sb.append(decimals.get(y));
            }
        }
        //System.out.println(String.format(decimals.toString()));
        //System.out.println(String.format(remainders.toString()));
        //System.out.println(String.format(sb.toString()));


        return sb.toString();
}

    public static void main(String[] argv) {
        System.out.println(division(2, 3));
    }
}
