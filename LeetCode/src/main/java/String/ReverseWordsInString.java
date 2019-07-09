/*
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
   Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 */
public class ReverseWordsInString {
	//一个空格 char的形式
	public static void reverseString(char[] str) {
		swap(str, 0, str.length);
		int index = 0;
		for (int i = 0; i < str.length; i++) {			
			if (str[i] == ' ') {
				swap(str, index, i-1);
				index = i+1;
			}
		}
		swap(str, index, str.length-1);
		return;
	}	
	private static void swap(char[] str, int i, int j) {
		if (i > j) return;		
		while ( i < j) {
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i ++;
			j --;
		}
	}
	//String形式 多个空格 全部reverse
	public static String reverse(String s) {
		char[] s_chars = s.toCharArray();
		swap(s_chars, 0, s.length()-1);
		
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s_chars[i] == ' ') {
				swap(s_chars, index, i-1);
				index = i+1;
			}			
		}
		swap(s_chars, index, s.length()-1);
		for (char c : s_chars) {
			if (c == ' ') {
				System.out.println("empty");
			}
			System.out.println(c);
		}
		return s_chars.toString();	
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I like And   ";	
		String ans = reverse(s);	
	}

}
