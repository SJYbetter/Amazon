class Solution {
/*
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

*/
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length==0 ) return 0;
        int[] map = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue(26, Collections.reverseOrder());

        for (char c: tasks)
            map[c - 'A']++;


        for (int f : map){
            if (f > 0){
                pq.offer(f);
            }
        }

        int ans = 0;
        while ( ! pq.isEmpty()){
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n){
                if (!pq.isEmpty()){
                    if (pq.peek() > 1){
                        temp.add(pq.poll()-1);
                    }else{
                        pq.poll();
                    }
                }
                ans ++;
                if (pq.isEmpty() && temp.size() == 0) break;
                i ++;
            }
            for (int x : temp){
                pq.offer(x);
            }
        }
        return ans;
    }
}
