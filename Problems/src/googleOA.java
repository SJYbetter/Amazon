import java.util.LinkedList;
import java.util.Queue;

public class googleOA {
	//calculate the finger move distance
	public static int moveFinger(String s1, String s2) {
		int[] keyboard = new int[26];
		int distance = 0, pre_position = 0;
		//put 
		for (int index = 0; index < 26; index ++) {
			char c = s1.charAt(index);
			keyboard[c - 'a'] = index;		
		}
		
		for (int i = 0; i < s2.length(); i ++) {
			char c = s2.charAt(i);
			int cur_position = keyboard[c - 'a'];
			distance += Math.abs(pre_position - cur_position);
			pre_position = cur_position;
		}
		
		return distance;
	}	
	
	//return the maxsum level
	public static int sumMax(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int maxLevel = 1;
		int level = 1;
		int maxSum = Integer.MIN_VALUE;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);

		
		while (!queue.isEmpty()) {
			int size = queue.size();
			int levelSum = 0;

			for (int i = 0; i < size; i++) {
				int node_index = queue.poll();
				levelSum += nums[node_index-1];
				
				if ( 2 * node_index <= nums.length) {
					queue.offer(node_index * 2);
				}
				if ( 2 * node_index + 1 <= nums.length) {
					queue.offer(node_index * 2 + 1);				
			    }				
			}
			System.out.println("level is" + level + "  sum is" + levelSum);
			
			if (levelSum > maxSum) {
				maxSum = levelSum;
				maxLevel = level;
			}
			level ++;		
		}
		return maxLevel;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = new int[]{1, -4, 5, 1};
		int level = sumMax(ans);
		System.out.println(level);

	}

}
