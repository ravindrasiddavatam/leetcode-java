/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {

        if (root == null) return;

        // Use a stack to store the nodes for pre-order traversal
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // Pointer to build the linked list
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (prev != null) {
                prev.left = null;  // Set the left child of the previous node to null
                prev.right = curr; // Set the right child of the previous node to the current node
            }

            if (curr.right != null) stack.push(curr.right); // Push right child to stack
            if (curr.left != null) stack.push(curr.left);   // Push left child to stack

            prev = curr; // Move the prev pointer to the current node
        }
    }

    // Helper method to print the flattened linked list
    public void printLinkedList(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");

        
    }
}
