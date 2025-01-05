class Solution {
    public int hammingWeight(int n) {
        
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
           // n = n % 2;
            sb.append(n % 2);
            n = n / 2; 
        }
        sb.reverse();
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '1'){
                result++;
            }
        }

        return result;
    }
}
