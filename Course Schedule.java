class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i <numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];

            graph[src].add(dest);
        }

        int[] visited = new int[numCourses];

         for (int i = 0; i <numCourses; i++) {
            if (hasCycle(graph, visited, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] graph, int[] visited, int node) {
        if (visited[node] == 1) return true; // Node is currently being visited (cycle detected)
        if (visited[node] == 2) return false; // Node has been fully processed (no cycle)

        // Mark the node as being visited
        visited[node] = 1;
        
        // Visit all the adjacent nodes
        for (int neighbor : graph[node]) {
            if (hasCycle(graph, visited, neighbor)) {
                return true;
            }
        }
        
        // Mark the node as fully processed
        visited[node] = 2;
        return false;

    }
}
