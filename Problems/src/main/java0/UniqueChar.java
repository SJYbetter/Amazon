import java.util.HashSet;
import java.util.Set;

public class UniqueChar {
	public static String uniqueChar(String s) {
		if ("".equals(s) || s.length() == 0) return "";

		Set<Character> set = new HashSet<>();
		StringBuilder ans = new StringBuilder();

		for (Character c : s.toCharArray()) {
			if (set.contains(c)) continue;
			else {
				ans.append(c);
				set.add(c);
			}
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniqueChar(""));
		System.out.println(uniqueChar("aaaBBBaaaNNN"));

	}

}
