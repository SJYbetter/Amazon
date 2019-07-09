package Array;
public class FirstBadVersion {
	public static class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	    	return bs(n, 1, n);
	    }
	    
	    private int bs(int n, int start, int end) {
			if (start == end) return start;
			int mid = start + (end - start) / 2;
			if (start < end) {
				if (isBadVersion(mid))
					return bs(n, start, mid);
				else
					return bs(n, mid + 1, end);
			}
			return mid;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
