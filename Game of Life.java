 class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Directions array to traverse the 8 neighbors
        int[] directions = {-1, 0, 1};

        // Step 1: Update the board with intermediate states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Check all 8 neighbors
                for (int dx : directions) {
                    for (int dy : directions) {
                        if (!(dx == 0 && dy == 0)) { // skip the cell itself
                            int x = i + dx;
                            int y = j + dy;

                            if (x >= 0 && x < m && y >= 0 && y < n && Math.abs(board[x][y]) == 1) {
                                liveNeighbors++;
                            }
                        }
                    }
                }

                // Apply the rules based on the current state and number of live neighbors
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // Live cell dies
                    board[i][j] = -1; // temporarily mark as -1 (1 -> 0)
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    // Dead cell becomes alive
                    board[i][j] = 2; // temporarily mark as 2 (0 -> 1)
                }
            }
        }

        // Step 2: Finalize the board by converting -1 -> 0 and 2 -> 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
