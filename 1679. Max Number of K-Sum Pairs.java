class Solution {
    public int maxOperations(int[] nums, int k) {
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int operations =0;

        for(int num:nums){
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }

        for(int num : countMap.keySet()){
            int complement = k - num;
            if(complement < num){
                continue;
            }

            if(countMap.containsKey(complement)){
                if(num == complement){
                    operations += countMap.get(num)/2;

                }else{
                    operations +=Math.min(countMap.get(num), countMap.get(complement));
                }
            }
        }
        return operations;
    }
}
