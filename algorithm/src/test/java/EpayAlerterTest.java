import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Arrays;

import static org.junit.Assert.*;

public class EpayAlerterTest {

    @Test
    public void test(){
        //int year = 2016;
        for(int year = 2000; year < 2020; year++) {
            GregorianCalendar cal = new GregorianCalendar(year, Calendar.OCTOBER, 1);

            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            int dayOffset = (10 - dayOfWeek) % 7 + 7 ;
            cal.add(Calendar.DAY_OF_WEEK, dayOffset);


            System.out.println(String.format("%s %d %d", cal.getTime().toString() , cal.get(Calendar.DAY_OF_MONTH), dayOffset));
            assertEquals(Calendar.TUESDAY, cal.get(Calendar.DAY_OF_WEEK));
        }
    }

    @Test
    public void testCase0() {
        Integer[] inputs = new Integer[]{1, 2, 100, 2, 2};

        boolean result = EpayAlerter.alerter_v1(Arrays.asList(inputs), 3, 1.5f);

        assertTrue(result);
    }

    @Test
    public void testCase1() {
        Integer[] inputs = new Integer[]{1, 2, 4, 2, 2};
        boolean result = EpayAlerter.alerter_v1(Arrays.asList(inputs), 3, 2f);
        assertFalse(result);
    }

    @Test
    public void testCase2() {
        Integer[] inputs = new Integer[]{1, 2, 100, 2, 2};
        boolean result = EpayAlerter.alerter_v1(Arrays.asList(inputs), 2, 2.5f);
        assertTrue(result);
    }
}
