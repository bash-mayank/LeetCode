class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int sum = 0;
        backtrack(0, result, current, nums, sum, target);
        return result;
    }

    private void backtrack(int i, List<List<Integer>>result, ArrayList<Integer>current, int[] nums, int sum , int target){

        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(sum > target){
            return;
        }

        for(; i<nums.length; i++){
            current.add(nums[i]);
            sum = sum + nums[i];
            backtrack(i, result, current, nums, sum, target);
            sum -= nums[i];
            current.remove(current.size()-1);
            
        }
    }
}