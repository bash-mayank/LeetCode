class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int sum = 0;
        backtrack(0, result, current, nums, sum, target);
        return result;
    }

    private void backtrack(int start, List<List<Integer>>result, ArrayList<Integer>current, int[] nums, int sum , int target){

        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(sum > target){
            return;
        }

        for( int i = start ; i<nums.length; i++){
            if(i> start && nums[i] == nums[i-1]) continue;
            if (sum + nums[i] > target) break;
            current.add(nums[i]);
            sum = sum + nums[i];
            backtrack(i+1, result, current, nums, sum, target);
            sum -= nums[i];
            current.remove(current.size()-1);
            
        }
    }
}