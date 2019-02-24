public class FirstUniqueCharacter{
    public int firstUnique(Stirng s){
      if (s == null || "".equals(s)) return -1;

      int[] check = new int[26];

      for (int i = 0; i < s.length(); i++){
        check[s.charAt(i) - 'a'] ++;
      }

      for (int i = 0; i < s.length(); i++){
        if (check[s.charAt(i) - 'a'] == 1) return i;
      }

      return -1;
    }
}
