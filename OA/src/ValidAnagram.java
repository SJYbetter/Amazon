public class ValidAnagram{
    public boolean validAnagram(Stirng s, String t){
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int j = 0; j < t.length(); j++){
            if (!map.contains(t.charAt(j))) return false;
            else{
                map.put(t.charAt(j), map.get(t.charAt(j))-1);
            }
        }

        for (Integer zero: map.values()){
            if (zero != 0) return false;
        }
        return true;
    }
}
