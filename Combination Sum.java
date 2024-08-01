class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentCombination, int[] candidates, int target, int start) {
        if(target == 0) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i<candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            currentCombination.add(candidates[i]);
            backtrack(results, currentCombination, candidates, target - candidates[i], i);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
