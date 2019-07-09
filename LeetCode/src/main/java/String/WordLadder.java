package String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        if(beginWord.equals(endWord)) return 1;        
        Set<String> set = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        set.add(beginWord);
        int length = 1;
        while ( !q.isEmpty()){
            length ++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                String word = q.poll();
                for (String nextWord : getNextWords(word, dict)){
                    if (set.contains(nextWord)) continue;
                    if (nextWord.equals(endWord)) return length;
                    set.add(nextWord);
                    q.offer(nextWord);
                }
            }
        }
        return 0;
        
    }
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
        private static List<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
     private static String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
