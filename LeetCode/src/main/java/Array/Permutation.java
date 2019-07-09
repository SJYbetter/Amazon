class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // store the answer
        List<List<Integer>> ans = new LinkedList<>();
        // edge case
        if(nums == null || nums.length == 0) return ans;
        //dfs by using recursion
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), ans);
        return ans;
        }

    private void dfs(int[] nums,
                     boolean[] visited, // check the number is vistied ot not
                     List<Integer> permutation, // the current one possible permutation
                     List<List<Integer>> ans
               ){
        // recursion exit
        if (permutation.size() == nums.length){
            // deep copy
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (visited[i] ) continue;

            // backtracking
            // [] --> [1]
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, ans);
            visited[i] = false;
            permutation.remove(permutation.size()-1);
        }
    }
}
