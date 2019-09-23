package OA.Dropbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GameOfLife {
    public void gameofLife(int[][] board){
        if (board == null || board.length == 0) return;
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 0, 0, -1, 1};

        int m = board.length, n = board[0].length;
        int dead = 0, live = 0;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                for (int k = 0; k < 8; k ++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (board[x][y] == 2 || board[x][y] == 0){
                        dead ++;
                    }else if (Math.abs(board[x][y]) == 1){
                        live ++;
                    }
                }
                //apply rules
                if (board[i][j] == 0){
                    if (live == 3) board[i][j] = 2;
                }else if (board[i][j] == 1){
                    if (live < 2 || live > 3) board[i][j] = -1;
                }
                dead = 0;
                live = 0;
            }
        }

        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (board[i][j] == 2){
                    board[i][j] = 1;
                }else if (board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("abs.text");
        FileInputStream stream = new FileInputStream(file);
        byte[][] board = new byte[3][100];
        for (int i = 0; i < 100; i ++){
            int nbyte;
            int start = 0;
            while (start < 100){
                if ((nbyte = stream.read(board[i], start, 100 - start)) == -1){
                    break;
                }
                start += nbyte;
            }
        }

    }
}
