/*solution: [] -> [1] ->[1,2] -> [1,2,3]
               -> [2] ->[2,3]
               -> [3]



*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        Arrays.sort(nums);
        //dfs inputs: nums is the array, 0 is the current index, list is current one subset, ans is the return answer
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> ans){
        // all nodes is the results
        // deep copy the results
        ans.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            //find start from index i+1 subset, like [1,2] -> [1,2,3]
            dfs(nums, i+1, subset,ans);
            //back tracking
            subset.remove(subset.size()-1);
        }
        //return;
    }
}
