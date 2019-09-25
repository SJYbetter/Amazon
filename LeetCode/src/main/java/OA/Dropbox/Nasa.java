package OA.Dropbox;
import java.awt.*;
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

    class Image{
        int id;
        //int img;
//        byte[] bytes;
//      public Image(byte[] bytes) {
//            this.bytes = bytes;

  //      }
    //    public byte[] getBytes() {
       //     return this.bytes;
     //   }

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
    public static class SpacePanorama {
        /**
         * initializes the data structure. rows x cols y is the sector layout.
         * width, height can be as large as 1K each.
         */
        class Node{
            Sector sector;
            Node next;
            Node prev;
        }

        //private Sector[][] pos;
        private Node head;
        private Node tail;
        private Map<Long, Node> map = new HashMap<>();

        public SpacePanorama() {
            //pos = new Sector[rows][cols];
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        private void deleteNode(Node node){
            Node front = node.prev;
            Node end = node.next;
            front.next = end;
            end.prev = front;
        }

        private void addNodeTail(Node node){
            Node cur = tail.prev;
            node.prev = cur;
            node.next = tail;
            cur.next = node;
            tail.prev = node;
        }

        private void moveToTail(Node node){
            this.deleteNode(node);
            this.addNodeTail(node);
        }

        /**
         * The Hubble will occasionally call this (via some radio wave communication)
         * to report new imagery for the sector at (y, x)
         * Images can be up to 1MB in size.
         */
        public void update(int x, int y, Image image) {

            long key = (long) x << 32 | y;
            Node node = map.get(key);
            if (node == null) {
                Node newNode = new Node();
                newNode.sector.x = x;
                newNode.sector.y = y;
                newNode.sector.img = image;
                map.put(key, newNode);
                this.addNodeTail(newNode);
            } else {
                //Node node = this.map.get(key);
                node.sector.img = image;
                this.moveToTail(node);
            }
        }

        /**
         * NASA will occasionally call this to check the view of a particular sector.
         */
        public Image fetch(int x, int y) {
            long key = (long)x << 32 | y;
            return map.get(key).sector.img;
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

    public static void main(String[] args){

        //imgs[1].id = 1;
        Image img1 = new Image(1);

        SpacePanorama nasa = new SpacePanorama();
        nasa.update(1,1, new Image(1));
        //nasa.update(1,3, imgs[3]);
        //nasa.update(1,4, imgs[4]);

        Image img = nasa.fetch(1,1);
        System.out.println(img.id);


    }
}
