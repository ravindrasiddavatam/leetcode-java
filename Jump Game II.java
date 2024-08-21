public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest we can reach from index i
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current range, make a jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we've already reached or exceeded the last index, no need to proceed further
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
