package OA.Dropbox;

import java.util.ArrayList;
import java.util.HashMap;

public class TransactionImpl {

    public static class Transaction{
        public HashMap<String, String> new_storage;

        public Transaction(HashMap<String,String> storage){
            this.new_storage = new HashMap<>();
            this.new_storage.putAll(storage);
        }
    }

    private HashMap<String, String> storages;

    private HashMap<Long, Transaction> all_tx;

    private long _wal_seq = 0;
    private Object _lock_obj = new Object();


    public long begin(){
        synchronized (_lock_obj){
            Transaction tx = new Transaction(storages);
            long txid = _wal_seq++;
            all_tx.put(txid, tx);
            return txid;
        }
    }

    public void update(long txid, String key, String value){
        Transaction tx = all_tx.get(txid);
        tx.new_storage.put(key, value);
    }

    public String read(long txid, String key){
        Transaction tx = all_tx.get(txid);
        return tx.new_storage.get(key);
    }

    public void commit(long txid){
        synchronized (_lock_obj){
            Transaction tx = all_tx.get(txid);
            this.storages =  tx.new_storage;
            all_tx.remove(txid);
        }
    }
}
