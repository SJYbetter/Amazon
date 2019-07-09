package String;
import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    private boolean[][] visited;
    private int m;
    private int n;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || words == null) return ans;

        m = board.length;
        n = board[0].length;

        for (String word : words){
            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n; j ++){
                    if (word.charAt(0) == board[i][j] && search(board, word, i, j , 0)){
                        ans.add(word);
                    }
                }
            }
        }
        return ans;
    }

    private boolean search(char[][] board, String word, int i, int j, int index){
        //exit
        if (index == word.length()) return true;
        //out of bound
        if (i >= m || i < 0 || j >= n || j < 0 || visited[i][j] || board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true;

        if(search(board, word, i-1, j, index+1) ||
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) ||
           search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }

}
