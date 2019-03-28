/*
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

*/




class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        //edge case
        if(strs == null || strs.length == 0) return list;
        //key is the sorted string, value is the origin string
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else {
                map.put(key, new ArrayList<String>(){{add(s);}});
            }
        }
        
        for(List<String> l : map.values()){
            list.add(l);
        }
        return list;
    }
}
