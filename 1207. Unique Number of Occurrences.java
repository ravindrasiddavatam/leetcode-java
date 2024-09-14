class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer,Integer> map1 =new HashMap<>();
        for(int num:arr){
            map1.put(num, map1.getOrDefault(num,0)+1);

        }

        Set<Integer> set1 = new HashSet<>();
        for(int freq: map1.values()){
            if(!set1.add(freq)){
                return false;
            }
        }
        return true;
    }
}
