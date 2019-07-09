package String;

public class AddStrings {
    private static String addStrings(String nums1, String nums2){
        int i = nums1.length()-1, j = nums2.length()-1;
        if (j > i) return addStrings(nums2, nums1);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0){
            int digit1 = nums1.charAt(i) - '0';
            int digit2 = nums2.charAt(j) - '0';
            carry += digit1 + digit2;
            //change int to character
            char c = (char)(carry%10 + 48);
            sb.append(c);
            carry /= 10;
            i --;
            j --;
        }
        //nums has remaining number
        while (i >= 0){
            int digit = nums1.charAt(i) - '0';
            carry += digit;
            char c = (char)(carry%10 + 48);
            sb.append(c);
            carry /= 10;
            i --;
        }
        //last digit
        if (carry == 1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(addStrings("100", "26999"));
    }
}
