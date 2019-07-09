import java.util.Arrays;

public class ValidAnagram {
	public static boolean isValid1(String s, String t) {
		if (s.length() != t.length()) return false;
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		
		Arrays.sort(ss);
		Arrays.sort(tt);
		
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] != tt[i]) return false;
		}
		return true;
	}
	
	public static boolean isValid2(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] check = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			check[s.charAt(i) - 'a'] ++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			check[t.charAt(i) - 'a'] --;
		}
		
		for (int i : check) {
			if (i != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isValid1("aba", "baa"));

	}

}
