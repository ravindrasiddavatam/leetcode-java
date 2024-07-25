class Solution {
    public int minInsertions(String s) {
        
        int leftNeeded = 0; // Tracks the number of '(' needed
        int rightNeeded = 0; // Tracks the number of ')' needed
        int insertions = 0; // Tracks the number of insertions needed

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rightNeeded += 2; // Each '(' needs two ')'
                // If rightNeeded is odd, it means we need an additional ')' to balance
                if (rightNeeded % 2 == 1) {
                    insertions++;
                    rightNeeded--;
                }
            } else {
                rightNeeded--; // Each ')' decreases the needed right parentheses count
                if (rightNeeded == -1) {
                    insertions++; // We need an additional '(' to balance the current ')'
                    rightNeeded = 1; // And we still need one more ')' to balance
                }
            }
        }

        // At the end, if there are still rightNeeded > 0, it means we need to add these many ')'
        return insertions + rightNeeded;
    }
}
