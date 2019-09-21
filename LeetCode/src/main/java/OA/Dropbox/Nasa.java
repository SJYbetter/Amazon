package OA.Dropbox;
import java.io.*;
import java.util.*;

/**
 * NASA selects Dropbox as it‍‌‌‍‌‍‍‍‌‌‌‍‍‌‍‌‌‌‌s official partner, and we’re tasked with managing
 * a panorama for the universe. The Hubble telescope (or some other voyager we
 * have out there) will occasionally snap a photo of a sector of the universe,
 * and transmit it to us. You are to help write a data structure to manage this.
 * For the purpose of this problem, assume that the observable universe has been
 * divided into 2D sectors. Sectors are indexed by x- and y-coordinates.
 */


public class Nasa {
/*
    class File {
        public File(String path) {

        }
        public Boolean exists() {


        }
        public byte[] read() {

        }
        public void write(byte[] bytes) {

        }
    }
*/

    class Image {
        public Image(byte[] bytes) {

        }
        //public byte[] getBytes() {

         // no more than 1MB in size
    }

    class Sector {
        int x;
        int y;
        Image img;
        public Sector(int x, int y, Image img) {
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
    public class SpacePanorama {
        /**
         * initializes the data structure. rows x cols y is the sector layout.
         * width, height can be as large as 1K each.
         */
        class Node{
            Sector sector;
            Node next;
            Node prev;
        }

        private Sector[][] pos;
        private Node head;
        private Node tail;
        private Map<int[], Node> map = new HashMap<>();

        public SpacePanorama(int rows, int cols) {
            pos = new Sector[rows][cols];
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        private void moveToHead(Sector sector){
            int[] pos = {sector.getY(), sector.getX()};
            Node cur = map.get(pos);
            Node next = head.next;
            head.next = cur;
            cur.prev = head;
            cur.next = next;
            next.prev = cur;
        }

        /**
         * The Hubble will occasionally call this (via some radio wave communication)
         * to report new imagery for the sector at (y, x)
         * Images can be up to 1MB in size.
         */
        public void update(int y, int x, Image image) {
            Sector sector = pos[x][y];
            sector.img = image;
            //int[] pos = {y,x};
            //Node cur = map.get(pos);
            moveToHead(sector);
        }

        /**
         * NASA will occasionally call this to check the view of a particular sector.
         */
        public Image fetch(int y, int x) {
            Sector sector = pos[y][x];
            return sector.img;
        }

        /**
         * return the 2D index of the sector that has the stalest data.
         * the idea is that this may help the telescope decide where to aim next.
         */
        public int[] getStalestSector() {
            Node tail_prev = tail.prev;
            Sector sector = tail_prev.sector;
            return new int[]{sector.getX(), sector.getY()};

        }
    }
}
