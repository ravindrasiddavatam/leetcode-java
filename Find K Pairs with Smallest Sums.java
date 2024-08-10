class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
     List<List<Integer>> result = new ArrayList<>();
        
        // Edge cases
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }
        
        // Min-heap to store the pairs (sum, i, j)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Initialize the heap with pairs from nums1[0] and each element in nums2
        for (int j = 0; j < nums2.length && j < k; j++) {
            minHeap.offer(new int[] {nums1[0] + nums2[j], 0, j});
        }
        
        // Extract the smallest pairs from the heap
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1], j = current[2];
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            result.add(pair);
            
            // If possible, push the next pair (i + 1, j) to the heap
            if (i + 1 < nums1.length) {
                minHeap.offer(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
            }
        }
        
        return result;
    }
}
