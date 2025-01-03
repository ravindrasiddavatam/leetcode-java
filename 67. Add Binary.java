class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while(i >=0 || j >=0 || carry!=0){

            int bit1 = i >=0 ? a.charAt(i) - '0' : 0;
            int bit2 = j >=0 ? b.charAt(j) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            carry = sum/2;
            result.append(sum%2);

            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
