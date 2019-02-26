import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for a Record class Record { public int id, score; public
 * Record(int id, int score){ this.id = id; this.score = score; } }
 */
public class CommonWords {
	// definition of record
	class Record {
		public int id, score;

		public Record(int id, int score) {
			this.id = id;
			this.score = score;
		}
	}

	public Map<Integer, Double> highFive(Record[] results) {
		// Write your code here
		// store answer
		Map<Integer, Double> answer = new HashMap<>();
		// use a map to store the information, key is the id, and the value is this id
		// corresponding highest five scores
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		// go through this list
		for (Record r : results) {
			// check whether this student is in the map or not, if not, just put this student id in map
			if (!map.containsKey(r.id)) {
				map.put(r.id, new PriorityQueue<>());
			}
			// 已经把新的id 放到这个map里了， 所以取出来，然后加成绩， 因为上一步没有加成绩的
			PriorityQueue<Integer> pq = map.get(r.id);

			if (pq.size() < 5)
				pq.add(r.score);
			else {
				// 如果size（）大于5了，就要判断一下加还是不加，依据是取出来minheap的顶端score，和目前的score相比较
				if (pq.peek() < r.score) {
					pq.poll();
					pq.add(r.score);
				}
			}
		}

		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			int id = entry.getKey();
			PriorityQueue<Integer> hiveScores = entry.getValue();
			double mean = 0.0;
			for (int i = 0; i < 5; i++) {
				mean += hiveScores.poll();
			}
			mean /= 5.0;
			answer.put(id, mean);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
