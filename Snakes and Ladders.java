class Solution {
    public int snakesAndLadders(int[][] board) {
        
         int n = board.length;
        int[] moves = new int[n * n + 1];
        Arrays.fill(moves, -1);
        
        // Convert the board into a 1D array considering the Boustrophedon pattern
        boolean leftToRight = true;
        int index = 1;
        for (int r = n - 1; r >= 0; r--) {
            if (leftToRight) {
                for (int c = 0; c < n; c++) {
                    moves[index++] = board[r][c];
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    moves[index++] = board[r][c];
                }
            }
            leftToRight = !leftToRight;
        }

        // BFS initialization
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(new int[]{1, 0}); // start at square 1 with 0 moves
        visited[1] = true;

        // BFS loop
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int movesCount = curr[1];

            // If we reach the last square
            if (pos == n * n) {
                return movesCount;
            }

            // Simulate dice rolls from 1 to 6
            for (int i = 1; i <= 6; i++) {
                int nextPos = pos + i;
                if (nextPos > n * n) break; // stay within bounds

                if (moves[nextPos] != -1) { // If there is a snake or ladder
                    nextPos = moves[nextPos];
                }

                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.offer(new int[]{nextPos, movesCount + 1});
                }
            }
        }

        // If we exit the loop without having reached the last square
        return -1;

        
    }
}
