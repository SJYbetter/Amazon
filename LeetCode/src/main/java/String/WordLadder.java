package String;

import java.util.*;

public class WordLadder {
    public int wordLadder(String start, String end, Set<String> dict) {
        if (dict == null) return 0;
        if (start.equals(end)) return 1;

        dict.add(start);
        dict.add(end);
        int length = 1;

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Set<String> check = new HashSet<>();
        check.add(start);

        while (!q.isEmpty()) {
            length++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curWord = q.poll();
                for (String word : getNextWords(curWord, dict)) {
                    if (check.contains(word)) continue;
                    if (word.equals(end)) {
                        return length;
                    }
                    //extension
                    q.offer(word);
                    check.add(word);
                }
            }
        }
        return 0;
    }


    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }



    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        //for (String i : wordList){
        //dict.add(i);
        //}
        if (beginWord.equals(endWord)) return 1;

        Set<String> set = new HashSet<String>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.add(beginWord);
        int length = 1;
        while (!q.isEmpty()) {
            length++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                for (String nextWord : getNextWords(word, dict)) {
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
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
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

}

