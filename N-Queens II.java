class Solution {
    public int totalNQueens(int n) {
        
        int[] result = new int[1];
        int[] positions = new int[n];

        solveNQueens(n, 0, positions, result);
        return result[0];

    }

    private void solveNQueens(int n, int row, int[] positions, int[] result){
        if(row == n){
            result[0]++;

        }else{
            for(int col =0;col<n;col++){
                if(isSafe(row,col, positions)){
                    positions[row] = col;
                    solveNQueens(n, row + 1, positions, result);
                }
            }
        }
    }

    private boolean isSafe(int row, int col, int[] positions){
        for(int i=0; i < row; i++){
            int placedQueen = positions[i];
            if(placedQueen == col || placedQueen - i == col - row || placedQueen + i == col + row){
                return false;
            }
        }
        return true;
    }
}
