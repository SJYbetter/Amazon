class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) return 0;
        if (needle.equals(haystack)) return 0;
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; ; i++){
            for (int j = 0; ; j++){
                if ( j == needle.length() ) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }

    }
}
