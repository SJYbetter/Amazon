package OA.VMwareOA;

import java.util.HashSet;
import java.util.Set;

public class EvenSubarray {
    public int evenSubarray(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            builder.setLength(0);
            int odd = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] % 2 == 1) {
                    odd++;
                }
                if(odd > k)
                    break;
                builder.append("{").append(nums[j]).append("},");
                set.add(builder.toString());
            }
        }

        return set.size();
    }

}
