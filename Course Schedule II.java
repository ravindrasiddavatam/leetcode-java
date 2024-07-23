class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Array to keep track of the in-degrees of each node
        int[] inDegree = new int[numCourses];
        
        // Fill the graph with edges from prerequisites and update in-degrees
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            graph[src].add(dest);
            inDegree[dest]++;
        }
        
        // Queue to process nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // List to store the topological order
        List<Integer> order = new ArrayList<>();
        
        // Process the nodes in the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // If the order size is less than numCourses, it means there's a cycle
        if (order.size() != numCourses) {
            return new int[0];
        }
        
        // Convert the order list to an array
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        
        return result;
        
    }
}
