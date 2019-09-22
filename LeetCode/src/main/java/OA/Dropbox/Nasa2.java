package OA.Dropbox;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Nasa2 {
     static class Image {
        private byte[] _bytes;

        public Image(byte[] bytes) {
            this._bytes = bytes;
        }

        public byte[] getBytes() {
            return this._bytes;  // no more than 1MB in size
        }
    }

    class Sector {
        int x;
        int y;
        Image img;
        public Sector(int x, int y, Nasa2.Image img) {
            this.x = x;
            this.y = y;
            this.img = img;
        }

        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
    }

    /**
     * row-major indexing to be consistent.
     */
    public static class SpacePanorama {
        /**
         * initializes the data structure. rows x cols y is the sector layout.
         * width, height can be as large as 1K each.
         */
//        class Node{
//            Nasa2.Sector sector;
//            Nasa2.SpacePanorama.Node next;
//            Nasa2.SpacePanorama.Node prev;
//        }
//
//        private Nasa2.Sector[][] pos;
//        private Nasa2.SpacePanorama.Node head;
//        private Nasa2.SpacePanorama.Node tail;
//        private Map<int[], Nasa2.SpacePanorama.Node> map = new HashMap<>();

        private String rootPath = null;

        public SpacePanorama(int rows, int cols, String rootPath) {
//            pos = new Nasa2.Sector[rows][cols];
//            head = new Nasa2.SpacePanorama.Node();
//            tail = new Nasa2.SpacePanorama.Node();
//            head.next = tail;
//            tail.prev = head;
            this.rootPath = rootPath;
        }

//        private void moveToHead(Nasa2.Sector sector){
//            int[] pos = {sector.getY(), sector.getX()};
//            Nasa2.SpacePanorama.Node cur = map.get(pos);
//            Nasa2.SpacePanorama.Node next = head.next;
//            head.next = cur;
//            cur.prev = head;
//            cur.next = next;
//            next.prev = cur;
//        }

        private  static final   String FILE_NAME_PATTERN = "row_%d_col_%d.jpg";


        private File buildFileName(int x, int y ) {
            return new File(rootPath, String.format("row_%d_col_%d.jpg", x, y));
        }

        private File createIndexFile(File imageFile) throws FileNotFoundException {
            String indexFileName = String.format("idx_%016X", System.currentTimeMillis());
            File file = new File(rootPath, indexFileName);
            return file;
        }

        /**
         * The Hubble will occasionally call this (via some radio wave communication)
         * to report new imagery for the sector at (y, x)
         * Images can be up to 1MB in size.
         */
        public void update(int y, int x, Image image) throws IOException {
            File filename = buildFileName(x, y);
            File index = createIndexFile(filename);

            if (filename.exists()){ // update old image, remove index first
                byte[] indexBytes = new byte[20];
                FileInputStream input = new FileInputStream(filename);
                try {
                    read_all(input, indexBytes);
                    File old_index_file = new File(rootPath,  new String(indexBytes,"UTF-8"));
                    if (old_index_file.exists())
                        old_index_file.delete(); // remove old timestamp index
                }finally {
                    input.close();
                }
            }

            FileOutputStream output = new FileOutputStream(filename);
            try {
                output.write(index.getName().getBytes()); // write index file name
                output.write(image.getBytes());
            }finally {
                output.close();
            }

            FileOutputStream indexOutput = new FileOutputStream(index);   // write current timestamp index for image file
            try{
                byte[] bytes = ByteBuffer.allocate(8).putInt(x).putInt(y).array();
                output.write(bytes);
            }finally {
                indexOutput.close();
            }
        }

        private static void read_all(FileInputStream stream, byte[] bytes) throws IOException {
            int totalBytes = 0;
            while(totalBytes < bytes.length){
                int nBytes = stream.read(bytes, totalBytes, bytes.length - totalBytes);
                if (nBytes == -1 )
                    throw new EOFException();
            }
        }

        private static void write_all(FileOutputStream output, byte[] bytes) throws IOException{
            output.write(bytes);
        }

        /**
         * NASA will occasionally call this to check the view of a particular sector.
         */
        public Image fetch(int y, int x) throws IOException {
            File filename = buildFileName(x, y);
            byte[] indexBytes = new byte[20];
            byte[] bytes = new byte[(int) filename.length() - 20];

            FileInputStream input = new FileInputStream(filename);
            try {
                read_all(input, indexBytes);  // skip timestamp index bytes
                read_all(input, bytes);
                return new Image(bytes);
            } finally {
                input.close();
            }
        }

        /**
         * return the 2D index of the sector that has the stalest data.
         * the idea is that this may help the telescope decide where to aim next.
         */
        public int[] getStalestSector() throws IOException {
            File root = new File(rootPath);
            File[] indexFiles = root.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().startsWith("idx_");
                }
            });
            Arrays.sort(indexFiles);
            File stale = indexFiles[0];
            FileInputStream input = new FileInputStream(stale);
            try {
                byte[] bytes = new byte[8];
                read_all(input, bytes);
                ByteBuffer buf = ByteBuffer.wrap(bytes);
                return new int[]{buf.getInt(), buf.getInt()};
            } finally {
                input.close();
            }
        }
    }
}
