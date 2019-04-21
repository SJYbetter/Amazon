import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EpayAlerterTest {

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
