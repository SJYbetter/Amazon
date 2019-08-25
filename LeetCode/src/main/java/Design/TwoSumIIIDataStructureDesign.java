package Design;
/*Design and implement a TwoSum class.
It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
*/


import java.util.HashSet;
import java.util.Set;

public class TwoSumIIIDataStructureDesign {
    private Set<Integer> set = new HashSet<>();

    public void addNumber(int number){
        if (!set.contains(number)){
            set.add(number);
        }
    }

    public boolean find(int sum){
        for (int i: set){
            int target = sum - i;
            if (set.contains(target)) return true;
        }
        return false;

    }


}
