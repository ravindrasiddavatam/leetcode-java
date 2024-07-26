class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
         Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        char[] genes = new char[] {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return level;
                
                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char oldChar = currentArray[j];
                    for (char gene : genes) {
                        if (gene == oldChar) continue;
                        currentArray[j] = gene;
                        String nextGene = new String(currentArray);
                        if (bankSet.contains(nextGene)) {
                            queue.add(nextGene);
                            bankSet.remove(nextGene);
                        }
                    }
                    currentArray[j] = oldChar;
                }
            }
            level++;
        }
        return -1;

    }
}
