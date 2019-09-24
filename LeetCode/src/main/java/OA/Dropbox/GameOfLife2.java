package OA.Dropbox;

import java.io.*;
import java.util.TreeMap;

public class GameOfLife2 {

    private static void read_all(InputStream input, byte[] bytes) throws IOException {
        int total_bytes = 0;
        while (total_bytes < bytes.length) {
            int nBytes = input.read(bytes, total_bytes, bytes.length - total_bytes);
            if (nBytes == -1)
                throw new EOFException("end of file");
            total_bytes += nBytes;
        }
    }

    private FileInputStream input;
    private FileOutputStream output;
    private TreeMap<Integer, byte[]> board = new TreeMap<Integer, byte[]>();
    private int nRow = 0; // 已经读取的行数
    private int i = 0; // 已经处理的行数

    /**
     * @param nBytes 每行字节数目
     * @param nLine  等待读取的行数，每次从0开始记数
     * @return
     */
    private boolean readBatch(int nBytes, int nLine) throws IOException {
        for (int i = 0; i < nLine; i++) {
            byte[] bytes = new byte[nBytes];
            try {
                read_all(input, bytes);
            } catch (EOFException e) { // 没有读取nBytes, 文件就结束了。但是bytes里有效长度可能大于0，此种情况无法处理
                return i == 0 ? false : true;  // 以及读取了1行or以上，有数据需要处理
            }
            board.put(nRow++, bytes);
        }
        return true;
    }

    /**
     * @param flushTo 输出flushTo行之前的所有记录
     * @param nColumn 每行字节数
     * @throws IOException
     */
    private void flushBatch(int flushTo, int nColumn) throws IOException {
        int minLine;
        while ((minLine = board.firstKey()) <= flushTo) {
            byte[] row = board.remove(minLine);
            for (int j = 0; j < nColumn; j++) {
                if (row[j] == 2) {
                    row[j] = 1;
                } else if (row[j] == -1) {
                    row[j] = 0;
                }
            }
            output.write(row);
        }
    }

    private void InternelGameOfLife2(int rowLimit, int nColumn) throws IOException {
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 0, 0, -1, 1};

        for (; i < rowLimit; i++) { // nRow 每次 readBatch会增加,除最后一次调用外，rowLimit = nRow -1
            int dead = 0, live = 0;
            for (int j = 0; j < nColumn; j++) {
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= nRow || y < 0 || y >= nColumn) continue;
                    byte[] row = board.get(x);
                    if (row[y] == 2 || row[y] == 0) {
                        dead++;
                    } else if (Math.abs(row[y]) == 1) {
                        live++;
                    }
                }

                //apply rules
                byte[] row = board.get(i);
                if (row[j] == 0) {
                    if (live == 3) row[j] = 2;
                } else if (row[j] == 1) {
                    if (live < 2 || live > 3) row[j] = -1;
                }
            }

            flushBatch(i - 1, nColumn);
        }
    }


    public void GameOfLifeEntry(String in, String out, int nColumn) throws IOException {
        input = new FileInputStream(in);
        try {
            output = new FileOutputStream(out);
            try {
                while (readBatch(nColumn, 3)) {
                    InternelGameOfLife2(nRow -1 , nColumn);
                }
                InternelGameOfLife2(nRow, nColumn);
                flushBatch(nRow, nColumn);
            } finally {
                output.close();
            }
        } finally {
            input.close();
        }
    }

    public static void main(String[] argv) {
        TreeMap<Integer, Integer> s = new TreeMap<>();
        s.put(9, 9);
        s.put(8, 8);
        s.put(100, 100);
        s.put(3,3);
        s.put(6, 6);
        while(s.size()>0){
            System.out.println(s.remove(s.firstKey()));
        }
    }

}
