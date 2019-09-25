package OA.Dropbox;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class GameOfLife3 {

    private MappedByteBuffer board;
    private int nColumn;

    public GameOfLife3(MappedByteBuffer board, int nColumn){
        this.board = board;
        this.nColumn = nColumn;
    }

    private byte get( int x, int y ){
        return board.get(x * nColumn + y);
    }

    private  void set(int x, int y, int value) {
        board.put(x * nColumn + y, (byte) value);
    }

    public void InternalGameOfLife() {
        if (board == null || board.limit() == 0) return;
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 0, 0, -1, 1};

        int m = board.limit() / nColumn, n = nColumn; // m: 多余不足一行的，可能会丢失

        for (int i = 0; i < m; i ++){
            int dead = 0, live = 0;
            for (int j = 0; j < n; j ++){
                for (int k = 0; k < 8; k ++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    byte v = get(x, y);
                    if ( v == 2 || v== 0){
                        dead ++;
                    }else if (Math.abs(v) == 1){
                        live ++;
                    }
                }

                //apply rules
                byte v = get(i, j);
                if (v == 0){
                    if (live == 3) set(i, j, 2);
                }else if (v == 1){
                    if (live < 2 || live > 3) set(i, j, -1);
                }
                dead = 0;
                live = 0;
            }
        }

        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                byte v = get(i, j);
                if (v == 2){
                    set(i, j, 1);
                }else if (v == -1){
                    set(i, j,0);
                }
            }
        }
    }


    public static void main(String[] argv) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(argv[0], "rw")){
            MappedByteBuffer board = raf.getChannel()
                    .map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
            new GameOfLife3(board, 100).InternalGameOfLife();
        }
    }
}
