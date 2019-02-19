
public class LongestPalindrome {

	public String longestPalindrome(String s) {
		// edge case
		if (s == null || s.length() < 1)
			return "";
		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = isPalin(s, i, i);
			int len2 = isPalin(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int isPalin(String s, int l, int r) {
		int L = l;
		int R = r;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

    //dp solution
	public String longestPalindrome_dp(String s) {
		if (s == null || s.length() == 0)
			return s;
		int n = s.length();
		// substring(i,j) is panlidrome
		boolean[][] dp = new boolean[n][n];
		String res = null;
		// [j, i]
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
					if (res == null || i - j + 1 > res.length()) {
						res = s.substring(j, i + 1);
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
