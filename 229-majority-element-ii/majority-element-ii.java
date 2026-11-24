class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int elem1 = 0;
        int elem2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(c1==0 && nums[i] != elem2){
                elem1 = nums[i];
                c1++;
            }
            else if(c2==0 && nums[i] != elem1){
                elem2 = nums[i];
                c2++;
            }
            else if(nums[i] == elem1){
                c1++;
            }
            else if(nums[i] == elem2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;

        for (int num : nums) {
            if (num == elem1) {
                c1++;
            }
            else if (num == elem2) {
                c2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (c1 > nums.length / 3) {
            ans.add(elem1);
        }

        if (c2 > nums.length / 3 && elem1 != elem2) {
            ans.add(elem2);
        }

        return ans;
    }
}