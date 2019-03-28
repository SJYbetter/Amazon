class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // corner case
        if(s == null && t == null) return false;
        // three cases
        // 1. length diff more than 1, false
        if(Math.abs(s.length()-t.length()) > 1) return false;
        // 2. length diff by 0, so change one char to be equal
        if(s.length() == t.length()) return isOneModify(s,t);
        // 3. length diff by 1, so delete one char from longer one
        if(s.length() > t.length()) return isOneDel(s,t);
        // ensure s.len > t.len
        return isOneDel(t,s);
    }

    public boolean isOneDel(String s,String t){
        // i indicates index of diff char
        int i = 0;
        for(; i < t.length(); i++){
            // if found, check rest substrings are equal or not
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(i + 1).equals(t.substring(i));
            }
        }
        // no diff, return true
        return true;
    }

    public boolean isOneModify(String s,String t){
        // diff indicates how many diff char between s and t
        int diff = 0;
        for(int i = 0; i < s.length(); i++){
            // find one and increase diff
            if(s.charAt(i) != t.charAt(i))
                diff++;
        }
        return diff == 1;
    }

}
