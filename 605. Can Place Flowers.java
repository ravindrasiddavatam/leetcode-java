public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        
        for (int i = 0; i < length && n > 0; i++) {
            // Check if current plot is empty (0)
            if (flowerbed[i] == 0) {
                // Check the left and right plots (boundary-safe)
                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1 || flowerbed[i + 1] == 0);
                
                // If both left and right are empty, plant a flower here
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1; // Plant a flower
                    n--; // Decrease the required number of flowers
                }
            }
        }
        
        // Return true if we planted all the required flowers
        return n == 0;
    }
}
