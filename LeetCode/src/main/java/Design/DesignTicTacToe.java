package Design;

import java.util.Map;

public class DesignTicTacToe {
    private int[] row;
    private int[] col;
    private int dignal = 0;
    private int antiDignal = 0;
    private int N;


    public DesignTicTacToe(int N){
        this.N = N;
        this.row = new int[N];
        this.col = new int[N];
    }
    //playerId has two 1 or 2
    public int move(int x, int y, int playerId) {
        int marker = (playerId == 1 ? 1 : -1);
        row[x] += marker;
        col[y] += marker;
        if (x == y){
            this.dignal += marker;
        }
        else if (x + y == N-1){
            this.antiDignal += marker;
        }
        if (Math.abs(row[x]) == N || Math.abs(col[y]) == N || Math.abs(antiDignal) == N || Math.abs(dignal) == N){
            return playerId;
        }
        return 0;
    }

}
