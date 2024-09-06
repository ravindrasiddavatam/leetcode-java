class Solution {
    public String reverseVowels(String s) {
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        //Convert the string to a character array for easier swapping

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;

        //Two pointer approach

        while(left < right){
            while(left < right && !vowels.contains(chars[left])) {
                left++;
            }

            while(left < right && !vowels.contains(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right]= temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
