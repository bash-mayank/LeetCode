class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        List<Boolean> map = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.add(false);
        }
        backtrack(nums, curr, map, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr, List<Boolean> map, List<List<Integer>> result){

        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(!map.get(i)){
                map.set(i, true);
                curr.add(nums[i]);
                backtrack(nums, curr, map, result);
                curr.remove(curr.size()-1);
                map.set(i, false);
            }

        }

    }
} 