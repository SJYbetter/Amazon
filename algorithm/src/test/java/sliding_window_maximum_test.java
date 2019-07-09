import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class sliding_window_maximum_test {

    @Test
    public void test_case_0(){
        int [] inputs = new int[]{};

        int[] result = new sliding_window_maximum().maxSlidingWindow_v1(inputs, 3);

        assertArrayEquals(result, new int[]{});
    }

    @Test
    public void test_case_1() {
        int[] inputs = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        int[] result = new sliding_window_maximum().maxSlidingWindow_v2(inputs, 3);

        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, result);
    }

    @Test
    public void alerter_test_case_1() {
        Integer[] input = new Integer[]{1, 2, 100, 2, 2, 50, 20};
        sliding_window_maximum.alerter_v2(Arrays.asList(input), 3, 1.5f);
    }

    @Test
    public  void alerter_test_case_2() {
        Integer[] input = new Integer[]{1, 2, 4, 2, 3};
        sliding_window_maximum.alerter_v2(Arrays.asList(input), 3, 2f);
    }

    @Test
    public  void alerter_test_case_3(){
        Integer[] input = new Integer[]{1, 2, 100, 2, 5};
        sliding_window_maximum.alerter_v2(Arrays.asList(input), 2, 1.5f);
    }
}
