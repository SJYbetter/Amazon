import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyWords {
	
	public static String[] topKFrequentWords(String[] words, int k) {
        // answer
        String[] topk = new String[k];
        if (words == null || words.length == 0) return new String[]{};
        // calculate the word and frequency
        Map<String, Integer> dict = new HashMap<>();
        // put all the words in the map
        for (String w : words){
            dict.put(w, dict.getOrDefault(w,0)+1);
        }
        // max heap 先比较frequency 如果一样的话，再比较首字母！！！！！
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue());
        //堆化处理 但是呢 n *log n
        for (Map.Entry<String, Integer> pair : dict.entrySet()){
            pq.offer(pair);
        }
        
        for (int i = 0; i < k; i++){
            topk[i] = pq.poll().getKey();
        }
        return topk;
    }
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
