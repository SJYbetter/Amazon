package OA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class WayFairOA {
    static class Tuple{
        int count;
        char c;
        public Tuple(int count, char c){
            this.count = count;
            this.c = c;
        }
    }


    public int magicSquare(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int K = Math.min(row, col);
        for (int i = K; i >= 0; i--) {
            for (int j = 0; j < row - K + 1; j++) {
                for (int c = 0; c < col - K + 1; c++) {

                }
            }
        }
        return 0;
    }






    private static int maxmiumInsert(String s){
        int countA = 0;
        int insertA = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a'){
                countA ++;
                if (countA == 3) return -1;
            }else{
                insertA += (2 - countA);
                countA = 0;
            }
        }
        if (s.lastIndexOf('a') != s.length() - 1){
            insertA += 2;
        }else{
            insertA += (2 - countA);
        }
        return insertA;
    }

    private static String diverseString(int A, int B, int C){
        int total = A + B + C;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((t1, t2) ->
                (t1.count == t2.count? t1.c - t2.c : t2.count - t1.count));

        StringBuilder sb = new StringBuilder();
        if (A != 0){
            pq.offer(new Tuple(A, 'a'));
        }
        if (B != 0){
            pq.offer(new Tuple(B, 'b'));
        }
        if (C != 0){
            pq.offer(new Tuple(C, 'c'));
        }

        while (pq.size() >= 2){
            Tuple tuple1 = pq.poll();
            Tuple tuple2 = pq.poll();
            if (tuple1.count >= 2){
                sb.append(tuple1.c);
                sb.append(tuple1.c);
                if (tuple1.count - 2 > 0){
                    tuple1.count -= 2;
                    pq.offer(tuple1);
                }
            }else{
                sb.append(tuple1.c);
            }

            if (tuple2.count >= 2){
                sb.append(tuple2.c);
                sb.append(tuple2.c);
                if (tuple2.count - 2 > 0){
                    tuple2.count -= 2;
                    pq.offer(tuple2);
                }
            }else{
                sb.append(tuple2.c);
            }
        }
        if (pq.size() == 1){
            Tuple last = pq.poll();
            if (last.count >= 2){
                sb.append(last.c);
                sb.append(last.c);
            }else{
                sb.append(last.c);
            }
        }
        return sb.toString();
    }

    private static int removeBALLON(String s){
        if (s == null || "".equals(s)) return 0;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'A'] ++;
        }

        int[] count = new int[5];
        count[0] = map['B' - 'A'];
        count[1] = map[0];
        count[2] = map['L' - 'A'];
        int l = map['L' - 'A'];
        count[3] = map['O' - 'A'];
        count[4] = map['N' - 'A'];
        Arrays.sort(count);
        if (count[0] * 2 < l ) return count[0];
        return l/2;
    }

    private static String noConsecutiveString(String s){

        if (s == null || "".equals(s)) return "";
        int len = s.length();
        s = s + "#";
        StringBuilder sb = new StringBuilder();
        int count = 1, i = 0, j = 0;
        while (i < len){
            while (s.charAt(i) == s.charAt(j) && j + 1< len){
                j ++;
            }
            if (j - i >= 2){
                sb.append(s.substring(i, i + 2));
            }else {
                sb.append(s.substring(i, j));
            }

            i = j;
        }
        return sb.toString();
    }

    public int game(int N, int K){
        int money = 1;
        int times = 0;
        dfs(times, N, K);
        return times;
    }
    private void dfs(int times, int N, int K){
        if (N <= 0) return;

    }

    public static void main(String[] args){
        //System.out.println(maxmiumInsert("aabcdaaaa"));
        //System.out.println(noConsecutiveString("ab"));
        //System.out.println(removeBALLON("BALLONBALLONA"));
        System.out.println(diverseString(0,1,8));
    }
}
