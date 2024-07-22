import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];
            
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, value);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / value);
        }
        
        // Process each query
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, 1.0, visited);
            }
        }
        
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double accProduct, Set<String> visited) {
        if (current.equals(target)) {
            return accProduct;
        }
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                double result = dfs(graph, entry.getKey(), target, accProduct * entry.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        
        double[] values = new double[]{2.0, 3.0};
        
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        
        double[] result = sol.calcEquation(equations, values, queries);
        
        System.out.println(Arrays.toString(result));
    }
}
