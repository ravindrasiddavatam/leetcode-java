

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        // Dictionary to keep a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        // Number of unique characters in t that need to be present in the desired window.
        int required = dictT.size();
        
        // Left and Right pointer
        int l = 0, r = 0;
        
        // Formed keeps track of how many unique characters in t are present in the current window in its desired frequency.
        int formed = 0;
        
        // Dictionary to keep a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();
        
        // The length of the smallest window.
        int[] ans = {-1, 0, 0}; // Format of ans is (window length, left, right)
        
        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            
            // If the frequency of the current character added matches the desired count in t, increase the formed count.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            
            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                // The character at the position pointed by the `left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                
                // Move the left pointer ahead to look for a new window.
                l++;
            }
            
            // Keep expanding the window by moving the right pointer to the right.
            r++;   
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
