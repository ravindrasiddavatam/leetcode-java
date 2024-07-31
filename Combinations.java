class Solution {
  
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        // If the combination is of the right length, add it to the result
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try each number from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            current.add(i); // Choose the current number
            backtrack(result, current, n, k, i + 1); // Recurse
            current.remove(current.size() - 1); // Backtrack
        }
    }

}
