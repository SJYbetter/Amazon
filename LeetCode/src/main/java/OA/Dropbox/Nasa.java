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
    //file class
    /*public class File {
        public File(String path){

        }

        public boolean exsits(){
            return true;
        }

        public byte[] read(){
            return new byte[]{};
        }

        public void write(byte[] bytes){

        }
    }
*/
    //sector class
    class Sector{
        int x;
        int y;
        Image img;
        public Sector(int x, int y, Image img){
            this.x = x;
            this.y = y;
            this.img = img;
        }

        Image getImage(int x, int y){
            return this.img;
        }
    }

    class Image{
        int width;
        int hight;
        public Image(int width, int hight){
            this.hight = hight;
            this.width = width;
        }
    }

    public class SpacePanorama{
        private Sector[][] grid;
        public SpacePanorama(int rows, int cols){
            grid = new Sector[rows][cols];

        }

        public void update(int x, int y, Image img){
            Sector cur = grid[x][y];
            cur.img = img;
        }

        public Image fetch(int x, int y){
            Sector pos = grid[x][y];
            return pos.img;

        }



    }
}
