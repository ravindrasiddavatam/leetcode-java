import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert the wordDict list to a set for faster lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Create a DP array to store if substrings can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: empty string can be segmented
        dp[0] = true;
        
        // Fill the DP array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if dp[j] is true and the substring s[j:i] is in the wordSet
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;  // Mark dp[i] as true
                    break;  // No need to check further, move to the next i
                }
            }
        }
        
        // Return whether the entire string can be segmented
        return dp[s.length()];
    }

   
    }

