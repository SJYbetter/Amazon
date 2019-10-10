public class AlienDictionary{
        public String alienOrder(String[] words) {
            if (words == null || words.length == 0) return "";
            Map<Character, Set<Character>> map = new HashMap<>();
            Map<Character, Integer> degree = new HashMap<>();

            for (String w: words){
                for (char c: w.toCharArray()){
                    //if (!degree.containsKey(c)){
                    degree.put(c, 0);

                }
            }

            for (int i = 0; i < words.length-1; i ++){
                String w1 = words[i];
                String w2 = words[i+1];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j ++){
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if (c1 != c2){
                        Set<Character> set = new HashSet<>();
                        if (!map.containsKey(c1)){
                            map.put(c1, set);
                        }else{
                            set = map.get(c1);
                        }
                        //we use check because otherwise we will add the degree+1
                        if (!set.contains(c2)){
                            map.get(c1).add(c2);
                            degree.put(c2, degree.get(c2)+1);
                        }

                        //if not same we cannot compare the later part because,没有基准了
                        break;
                    }
                }
            }

            //bfs
            Queue<Character> q = new LinkedList<>();
            String ans = "";

            for (char c: degree.keySet()){
                if (degree.get(c) == 0){
                    q.offer(c);
                }
            }

            while (!q.isEmpty()){
                char cur = q.poll();
                ans += cur;
                if (map.containsKey(cur)){
                    for(char c : map.get(cur)){
                        degree.put(c, degree.get(c)-1);
                        if (degree.get(c) == 0){
                            q.offer(c);
                        }

                    }
                }
            }
            //which means using 拓扑 cannot decide some chars we just return ""
            if (ans.length() != degree.size()) return "";
            return ans;
        }
}
