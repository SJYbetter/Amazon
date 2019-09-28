package OA;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.*;

public class CommuteTime {

    public static double log2(int n)
    {
        return  (Math.log10(n) / Math.log10(2));
    }

    static long log(int x, int base)
    {
        return Math.round (Math.log(x) / Math.log(base));
    }

    public static void main(String[] argv) {
//        BufferedInputStream stream = new BufferedInputStream(System.in);
//        BufferedReader reader = new BufferedReader( stream);

        String z = "4 2 11 6 5 1 4 3 5 6 8 7 7 12 1";
        String s = "14 15 15 14 13 19 21 10";
        Scanner scanner = new Scanner(s);
        try {
            ArrayList<Integer> inputs = new ArrayList<Integer>();
            while(scanner.hasNext()){
                inputs.add( (int)Math.round( scanner.nextDouble()));
            }
            Collections.sort(inputs);

            int min = inputs.get(0);
            int max = inputs.get(inputs.size()-1);
            long k = (long) log(inputs.size(),2);

            TreeMap<Long, Integer> counts = new TreeMap<Long, Integer>();
            for (Integer i : inputs) {
                long pos = ((int)(Math.round( i - min)  / k)) * k + min;
                // System.out.println(String.format("%d %d", i, pos));
                Integer c = counts.get(pos);
                if (c != null) {
                    counts.put(pos, c+1);
                }else{
                    counts.put(pos, 1);
                }
            }
            ArrayList<String> result = new ArrayList<String>();
            for(Map.Entry<Long, Integer> v: counts.entrySet()){
                System.out.println(String.format("%d %d", v.getKey(), v.getValue()));
                long y = Math.round (((v.getValue() * 1.0)/ inputs.size() * 100));
                result.add(Long.toString(y));
            }
            System.out.println(String.join(" ", result));
        } finally {
            scanner.close();
        }
    }
}

/*

 */