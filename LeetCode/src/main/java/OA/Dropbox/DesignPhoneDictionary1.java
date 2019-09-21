package OA.Dropbox;

import java.util.BitSet;

public class DesignPhoneDictionary1 {
    BitSet bitset;
    int max;

    public DesignPhoneDictionary1(int maxNumber){
        bitset = new BitSet(maxNumber);
        max = maxNumber;
    }

    public int get(){
        int num = bitset.nextClearBit(0);
        if (num == max) return -1;
        bitset.flip(num);
        return num;
    }

    public boolean check(int num){
        if (bitset.get(num)) return false;
        return true;
    }

    public void release(int num){
        bitset.clear(num);
    }
}
