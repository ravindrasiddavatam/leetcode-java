public class Solution {
    
    public String gcdOfStrings(String str1, String str2) {
        // Find the GCD of the lengths of the two strings
        int gcdLen = gcd(str1.length(), str2.length());
        
        // The candidate GCD string is the substring of str1 from 0 to gcdLen
        String candidateGCD = str1.substring(0, gcdLen);
        
        // Check if candidateGCD can divide both str1 and str2
        if (canDivide(str1, candidateGCD) && canDivide(str2, candidateGCD)) {
            return candidateGCD;
        } else {
            return ""; // No common divisor string
        }
    }
    
    // Function to check if 't' divides 's'
    private boolean canDivide(String s, String t) {
        int repeatCount = s.length() / t.length();
        StringBuilder repeatedT = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            repeatedT.append(t);
        }
        return repeatedT.toString().equals(s);
    }
    
    // Function to compute the GCD of two integers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
