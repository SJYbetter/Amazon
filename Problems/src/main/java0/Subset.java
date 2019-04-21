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
//with duplicate
public List<List<Integer>> subsetsWithDup(int[] nums) {
      // write your code here
      List<List<Integer>> results = new ArrayList<List<Integer>>();
      if (nums == null) return results;

      if (nums.length == 0) {
          results.add(new ArrayList<Integer>());
          return results;
      }
      Arrays.sort(nums);

      List<Integer> subset = new ArrayList<Integer>();
      helper(nums, 0, subset, results);

      return results;


  }
  public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results){
      results.add(new ArrayList<Integer>(subset));
      for(int i=startIndex; i<nums.length; i++){
          if (i != startIndex && nums[i]==nums[i-1]) {
              continue;
          }
          subset.add(nums[i]);
          helper(nums, i+1, subset, results);
          subset.remove(subset.size()-1);
      }
  }
