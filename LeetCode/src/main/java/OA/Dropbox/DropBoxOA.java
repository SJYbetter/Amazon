package OA.Dropbox;

import DS.Trie;

import java.util.*;

public class DropBoxOA {

    static class TrieNode{
        TrieNode[] child = new TrieNode[26];
        int maxScore = 0;
    }
    static class Trie {

        TrieNode root;
        Trie(){
            this.root = new TrieNode();
        }

        public void insert(String word, int score){
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++){
                int pos = word.charAt(i) - 'A';
                if (cur.child[pos] == null){
                    cur.child[pos] = new TrieNode();
                    cur.child[pos].maxScore = score;
                }else{
                    if (cur.child[pos].maxScore < score){
                        cur.child[pos].maxScore = score;
                    }
                }
                cur = cur.child[pos];
            }
        }

        public int maxScorePrefix(String prefix){
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++){
                int pos = prefix.charAt(i) - 'A';
                if (cur.child[pos] == null){
                    throw new ArithmeticException("invalid prefix");
                }else{
                    cur = cur.child[pos];
                }
            }
            return cur.maxScore;
        }
    }


    public  static Map<String, Integer> scoreCount(List<String> title, List<String> body){
        Map<String, Integer> wordMap = new HashMap<>();
        for (String t: title){
            for (String word: t.split(" ")){
                if (!wordMap.containsKey(word)){
                    wordMap.put(word, 10);
                }else{
                    wordMap.put(word, wordMap.get(word) + 10);
                }
            }

        }

        for (String sentence: body){
            for (String word: sentence.split(" ")){
                if (!wordMap.containsKey(word)){
                    wordMap.put(word, 1);
                }else{
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }
        return wordMap;

    }



    public static List<Integer> autoComplete(List<String> title, List<String> body, List<String> query){

        List< Integer> ans = new ArrayList<>();
        if (title == null || body == null) return ans;

        Map<String, Integer> wordMap = scoreCount(title, body);

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        //build treemap
        for (Map.Entry<String, Integer> entry: wordMap.entrySet()){
            String word = entry.getKey();
            Integer score = entry.getValue();
            for (int i = word.length(); i > 0; i --){
                String s = word.substring(0, i);
                if (!treeMap.containsKey(s)){
                    treeMap.put(s, score);
                }else{
                    int curScore = treeMap.get(s);
                    if (curScore < score){
                        treeMap.put(s, score);
                    }else{
                        break;
                    }
                }

            }
        }

        //query
        for (String prefix: query){
            ans.add(treeMap.get(prefix));
        }
        return ans;
    }

    public static List<Integer> autoComplete2(List<String> title, List<String> body, List<String> query){
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = scoreCount(title, body);
        Trie trie = new Trie();

        for (Map.Entry<String, Integer> entry: map.entrySet()){
            //if ("".equals(entry.getKey())) continue;
            trie.insert(entry.getKey(), entry.getValue());
        }

        for (String prefix: query){
            ans.add(trie.maxScorePrefix(prefix));
        }
        return ans;
    }

    public static void main(String[] args){
        List<String> titles = new ArrayList<>();
        titles.add("ANIMALS");
        titles.add("DOG FACTS");
        List<String> bodys = new ArrayList<>();
        bodys.add("ANT ANTELOPE CAMEL CAT DOG");
        bodys.add("FURRY FURRY LOYAL");
        List<String> querys = new ArrayList<>();
        querys.add("AN");
        querys.add("DO");
        querys.add("FUR");
        List<Integer> ans = autoComplete(titles, bodys, querys);

        List<Integer> ans1 = autoComplete2(titles, bodys, querys);


        for (int i = 0; i < ans.size(); i++){
            System.out.println("method1" + " " + ans.get(i));
            System.out.println("method2" + " " + ans1.get(i));
        }



    }

}
