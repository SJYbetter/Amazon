package Trie;

/*
public class ImplementTrie {

    TrieNode root;

    public ImplementTrie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if (cur.child[pos] == null){
                cur.child[pos] = new TrieNode();
            }
            cur = cur.child[pos];
        }
        cur.isword = true;
    }
    public boolean search(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if (cur.child[pos] == null) return false;
            cur = cur.child[pos];
        }
        return true;
    }

    public boolean startWith(String prefix){
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++){
            int pos = prefix.charAt(i) - 'a';
            if (cur.child[pos] == null) return false;
            cur = cur.child[pos];
        }
        return true;
    }

}


 */
