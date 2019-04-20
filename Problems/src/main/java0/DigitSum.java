
public class DigitSum {
	
	
	public static int getDigitSumParity(int[] arr) {
		int min = getMin(arr);
		int sum = getSum(min);
		if (sum % 2 == 0) return 1;
		else return 0;
	}
	
	public static int getMin(int[] arr) {
		int min = arr[0];
		for (int i : arr) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}
	
	public static int getSum(int num) {
		int sum = 0;
		while (num != 0) {
			int temp = num % 10;
			sum += temp;
			num = num / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {111,231,31,55};
		System.out.println(getDigitSumParity(array) );

	}

}
