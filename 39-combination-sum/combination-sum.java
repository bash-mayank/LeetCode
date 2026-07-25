class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int sum = 0;
        backtrack(0, result, current, nums, sum, target);
        return result;
    }
    private void backtrack(int index, List<List<Integer>> result, List<Integer> current, int[] nums, int sum, int target){
        // base condition
        if (sum > target) {
            return;
        }
       if (index == nums.length) {
            if (sum == target) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(nums[index]);
        backtrack(index, result, current, nums, sum + nums[index], target);
        current.remove(current.size()-1);
        backtrack(index+1, result, current, nums, sum, target);
    }
}