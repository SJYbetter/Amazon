class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public boolean hasWord = false;
}


class Trie {

    //public TrieNode[] children = new TrieNode[26];
    //public boolean hasWord = false;
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null){
                cur.children[pos] = new TrieNode();
            }
            //move to next char
            cur = cur.children[pos];
        }
        cur.hasWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            //cannot find it
            if (cur.children[pos] == null){
                return false;
            }
            cur = cur.children[pos];
        }
        return cur.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++){
            int pos = prefix.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                return false;
            }
            cur = cur.children[pos];
        }
        return true;
    }
}
