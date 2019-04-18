class Solution {

    //using map
    public boolean canPermutePalindrome(String s) {
        if (s == null || "".equals(s)) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.getOrDefault(c,0)+1);
            }else map.put(c, 1);
        }
        //count how many char's frequency is odd
        int count= 0;
        for (int times: map.values()){
            if (times % 2 == 1) count++;
        }

        if (count == 0 || count == 1) return true;
        return false;
    }

    //using list
    
}
