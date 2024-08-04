class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int currentMax = nums[0];
        int globalMax = nums[0];

        for(int i=1; i<nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            if(currentMax > globalMax) {
                globalMax = currentMax;
            }
        }
            return globalMax;
    }
}
