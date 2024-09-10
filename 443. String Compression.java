public class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;  // Pointer to write the compressed result
        
        for (int i = 0; i < n; ) {
            char currentChar = chars[i];
            int count = 0;
            
            // Count the number of occurrences of the current character
            while (i < n && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            // Write the character to the 'index' position
            chars[index++] = currentChar;
            
            // If the count is greater than 1, write the count as well
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        
        // Return the length of the compressed array
        return index;
    }
    
}
