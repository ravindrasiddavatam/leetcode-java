class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Calculate the diameter passing through this node
        int currentDiameter = leftHeight + rightHeight;

        // Update the global diameter if the current one is larger
        diameter = Math.max(diameter, currentDiameter);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
