
public class NotRepeatCharacter {
	public static char firstNotRepeat(String s) {
		if (s == null || "".equals(s)) return ' ';
		int[] check = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			check[s.charAt(i) - 'a'] ++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (check[s.charAt(i) - 'a'] == 1) {
				return s.charAt(i);
			}
		}
		return ' ';
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
