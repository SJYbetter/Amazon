
public class StringCompression {
	//out put the index
	public static int compress(char[] chars) {
		int index = 0, i = 0;
		while (i < chars.length) {
			char cur = chars[i];
			int count = 0;
			//find same characters
			while (i < chars.length && chars[i] == cur) {
				count ++;
				i ++;
			}
			chars[index ++] = cur;
			// 188 => 1, 8, 8
			if (count != 1) {
				for (char c: Integer.toString(count).toCharArray()) {
					chars[index ++] = c;
				}
			}
		}
		return index;
	}
	//out put the compressed string
    public static String compress1(String originalString) {
        // write your code here
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        while (j < originalString.length()){
            ans.append(originalString.charAt(i));
            
            int count = 0;
            while (j < originalString.length() && originalString.charAt(i) == originalString.charAt(j)){
                j ++;
                count ++;
            }
            //update i and append the how many times this character appear
            i = j;
            ans.append(Integer.toString(count));
        }
        if (ans.toString().length() > originalString.length()) {
        	return originalString;
        }   
        System.out.print(ans.toString());
        return ans.toString();
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] test1 = {'a', 'a', 'a','a', 'a', 'a','a', 'a', 'a','a', 'a', 'a','q'};
	
		int ans = compress(test1);
		String a = "aaaaaaaaaaabbbbccccd";
		String b = compress1(a);
	}

}
