class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num:nums1){
            set1.add(num);
        }

        for(int num:nums2){
            set2.add(num);
        }

        List<Integer> answer1 = new ArrayList<>(set1);
        answer1.removeAll(set2);


        List<Integer> answer2 = new ArrayList<>(set2);
        answer2.removeAll(set1);

        List<List<Integer>> result = new ArrayList<>();
        result.add(answer1);
        result.add(answer2);

        return result;
    }
}
