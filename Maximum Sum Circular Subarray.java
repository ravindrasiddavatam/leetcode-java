class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int maxKadane = kadane(nums);
        int totalSum =0;
        int n = nums.length;

        for(int i=0; i < n; i++) {
            totalSum+= nums[i];
            nums[i] = -nums[i];
        }

        int maxCircular = totalSum + kadane(nums);

        if(maxCircular == 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, maxCircular);
    }

    private static int kadane(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
      //  nums = [1,-2,3,-2]
        for(int i = 1; i < nums.length; i++) {

             maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
             maxSoFar      = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
