package Design;

class HashFunction{

    public int hashCode(char[] key, int HASH_SIZE){
        long ans=0;
        for (int i=0;i < key.length;i++){
            ans = (ans*33 + (int)(key[i])) % HASH_SIZE;
        }
        // return type
        return(int)ans;
    }

    public static void main(String[] args){

    }
}
