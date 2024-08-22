class RandomizedSet {

    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> indices;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        rand = new Random();
        
    }
    
    public boolean insert(int val) {
        if(indices.containsKey(val)) {
            return false;
        }
        nums.add(val);
        indices.put(val, nums.size()-1);
        return true;
        
    }
    
    public boolean remove(int val) {
        
        if(!indices.containsKey(val)){
            return false;
        }
        int index = indices.get(val);
        int lastElement = nums.get(nums.size()-1);

        nums.set(index, lastElement);
        indices.put(lastElement, index);

        nums.remove(nums.size()-1);
        indices.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
