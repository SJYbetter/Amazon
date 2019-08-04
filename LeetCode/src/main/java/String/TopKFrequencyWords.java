package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyWords {

	public List<String> topKFrequentWords(String[] words, int k) {
        // answer
        List<String> topk = new ArrayList<>();
        if (words == null || words.length == 0) return topk;
        // calculate the word and frequency
        Map<String, Integer> dict = new HashMap<>();
        // put all the words in the map
        for (String w : words){
            dict.put(w, dict.getOrDefault(w, 0) + 1);
        }
        // min heap 先比较frequency 如果一样的话，再比较首字母！！！！！
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        //堆化处理 但是呢 n *log k
        for (Map.Entry<String, Integer> pair : dict.entrySet()){
            pq.offer(pair);
			if (pq.size() > k){
				pq.poll();  
			}
        }

        for (int i = 0; i < k; i++){
            topk.add(0, pq.poll().getKey());
        }
        return topk;
    }




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
