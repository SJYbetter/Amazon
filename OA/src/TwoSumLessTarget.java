import java.util.Collections;
import java.util.List;

public class TwoSumLessTarget {
	
	public static double[] twoSumLessTarget(List<Double> list, double target) {
		double[] ans = new double[2];
		
		if (list == null || list.size() < 2) return ans;
		
		Collections.sort(list);
		int left = 0, right = list.size()-1;
		
		while (left < right) {
			
			
			if (list.get(left) + list.get(right) < target) {
				left ++;
				
			}else if (list.get(left) + list.get(right) == target) {
				ans[0] = list.get(left), ans[1] = list.get(right);
				
			}else if ()
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
