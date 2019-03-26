//Input: ["flower","flow","flight"]
//Output: "fl"


class Solution {
    public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0){
        return "";
    }
    String answer = strs[0];
    int i = 1;
    while (i < strs.length){
        while(strs[i].indexOf(answer) != 0){
            answer = answer.substring(0, answer.length()-1);
        }
        i ++;
    }
    return answer;
    }            
}
