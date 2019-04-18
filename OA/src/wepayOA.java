import java.util.Calendar;

public class wepayOA {
	
	public static boolean alert(int[] nums, int window, double weight) {
		if (nums == null || nums.length == 0 || window == 0) return false;
		
		return false;
	}
	
	
	public static int dayOfWeek(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.DATE, 1);
						
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		
		if (day <= 3) {
			return (3 - day + 8);
		}
		
		return (7 - day + 11);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dayOfWeek(2019));
		

	}

}
