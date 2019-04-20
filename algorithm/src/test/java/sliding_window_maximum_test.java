import org.junit.Test;
import static org.junit.Assert.*;

public class sliding_window_maximum_test {

    @Test
    public void test_case_0(){
        int [] inputs = new int[]{};

        int[] result = new sliding_window_maximum().maxSlidingWindow(inputs, 3);

        assertArrayEquals(result, new int[]{});
    }

    @Test
    public void test_case_1() {
        int[] inputs = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        int[] result = new sliding_window_maximum().maxSlidingWindow_v2(inputs, 3);

        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, result);
    }
}
