package DS;

public class Trie {

        TrieNode root;
        public Trie(){
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
