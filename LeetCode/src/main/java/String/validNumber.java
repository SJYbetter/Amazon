package String;

import java.util.HashSet;
import java.util.Set;

public class validNumber {
    //"000"? leading zero
	//leading/tail space 
	//sign must be in the first position
	//the left side and right side of point should have number, only have one point
	//must have number  abx
	//another char is not valid 
	public static boolean isNumber(String s) {
		if (s == null || "".equals(s)) return false;
		s = s.trim();
		boolean number = false;
		boolean point = false;
		boolean numThenPoint = false;
		boolean pointThenNum = false;
		//go through the string to check each valid case
		for (int i = 0; i < s.length(); i++) {
			//if the current char is a number 
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				number = true;
				//left side
				if (point == false) {
					numThenPoint = true;
				}
				//right side
				if (point == true) {
					pointThenNum = true;
				}
			}else if(s.charAt(i) == '.') {
				//.888.
				if (point == true) return false;
				point = true;
				
			}else if('-' == s.charAt(i) || '+' == s.charAt(i)) {
				if (i != 0) {
					return false;
				}			
			}else {
				//others characters
				return false;
			}
		}
		
		if (point == true) return numThenPoint && pointThenNum;
		return number;
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "0+4", s2 = "99 1", s3 = "..88..8", s4="10000.", s5="0.00";
		System.out.println(isNumber(s1));
		System.out.println(isNumber(s2));
		System.out.println(isNumber(s3));
		System.out.println(isNumber(s4));
		System.out.println(isNumber(s5));
	}

}
