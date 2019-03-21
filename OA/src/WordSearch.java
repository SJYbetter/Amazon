class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (word == null || "".equals(word)) return true;

        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int index){
        // exit condition, the last char is found
        if (index == word.length()) return true;
        // out of bound
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        //set true;
        visited[i][j] = true;

        if(search(board, word, i-1, j, index+1) ||
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) ||
           search(board, word, i, j+1, index+1)){
            return true;
        }
        //cannot find it should set back to false
        visited[i][j] = false;
        return false;

    }
}
