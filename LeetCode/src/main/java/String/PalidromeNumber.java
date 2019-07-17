package String;

public class PalidromeNumber {
	private static boolean palidromeNumber(int x) {
		if (x < 0) return false;
		String s = Integer.toString(x);
		int i = 0, j = s.length()-1;
		while ( i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}else {
				i ++;
				j --;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palidromeNumber(121));
		System.out.println(palidromeNumber(-121));
		System.out.println(palidromeNumber(0));

	}

}
