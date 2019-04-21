public class FirstUniqueCharacter{
    //返回index
    public static int firstUnique(String s){
      if (s == null || "".equals(s)) return -1;

      int[] check = new int[26];
      //calculate the frequency
      for (int i = 0; i < s.length(); i++){
        check[s.charAt(i) - 'a'] ++;
      }
      //go through the array to check which position the frequency is first appear 1
      for (int i = 0; i < s.length(); i++){
        if (check[s.charAt(i) - 'a'] == 1) return i;
      }

      return -1;
    }




    //返回char
    public char firstUniqChar(String str) {
    // Write your code here
    if (str == null || "".equals(str)) return (char) -1;

    char[] check = new char[26];

    for (int i = 0; i < str.length(); i++){
        check[str.charAt(i) - 'a'] += 1;
    }

    for (int i = 0; i < str.length(); i++){
        if (check[str.charAt(i) - 'a'] == 1) return str.charAt(i);
    }
    return (char) -1;
}
}
