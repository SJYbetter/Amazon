package OA.Dropbox;

public class SharpnessValue {
    public static int findSharpness(int[][] board){
        if (board == null || board.length == 0) return 0;
        int n = board.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            dp[i] = board[0][i];
        }

        for (int i = 1; i < board[0].length; i ++){
            for (int j = 0; j < n; j ++){
                dp[i] = Math.min(getRightSideMini(j, i, board), dp[i]);
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    private static int getRightSideMini(int x, int y, int[][] board){
        int max = Integer.MIN_VALUE;
        int[] dx = {-1, 0, 1};
        for (int i = 0; i < 3; i ++){
            if (x + dx[i] < 0 || x + dx[i] >= board.length) continue;
            max = Math.max(board[x+dx[i]][y], max);
        }
        return max;
    }

    public static void main(String[] args){
        int[][] b = {{5,7,2}, {7,5,8}, {9,1,5}};
        System.out.println(findSharpness(b));

    }

}


