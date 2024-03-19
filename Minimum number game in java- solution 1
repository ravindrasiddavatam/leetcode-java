class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int minimum = 0;
        int secMinimum = 0;
        int j = 0;
        for (int i = 0; i < nums.length;) {
            minimum=nums[i];
            i=i+1;
            secMinimum=nums[i];
            i=i+1;
            arr[j]=secMinimum;
            j=j+1;
            arr[j]=minimum;
            j=j+1;
        }
        return arr;
    }
}
