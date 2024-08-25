class Solution {
    public String intToRoman(int num) {
        
        int[] values = {1000, 900, 500, 400, 100, 90,50,40, 10,9,5,4,1};
         String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Iterate over the values and symbols arrays
        for (int i = 0; i < values.length; i++) {
            // Subtract the largest possible value and append the corresponding symbol
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        
        return roman.toString();
        
    }
}
