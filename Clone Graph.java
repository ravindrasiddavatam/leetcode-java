import java.util.*;

class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return clone(node);
    }

    private Node clone(Node node) {
        // If the node is already cloned, return the clone from the map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new node with the same value as the original node
        Node cloneNode = new Node(node.val);
        // Add this node to the map
        visited.put(node, cloneNode);

        // Recursively clone all the neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(clone(neighbor));
        }

        return cloneNode;
    }
}
