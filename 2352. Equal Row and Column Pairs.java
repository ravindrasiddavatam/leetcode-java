class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        for(int i=0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<n;j++){
                row.add(grid[i][j]);
            }

            rowMap.put(row, rowMap.getOrDefault(row,0)+1);
        }

         // Step 2: Compare each column to rows
        int count = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                col.add(grid[i][j]);
            }
            // Check if the column matches any row stored in the map
            if (rowMap.containsKey(col)) {
                count += rowMap.get(col);  // Add the number of matching rows
            }
        }
        
        return count;
    }   
}
