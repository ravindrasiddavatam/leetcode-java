/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        // Add the head of each list to the priority queue

        for(ListNode list:lists) {
            if(list != null) {
                queue.add(list);
            }
        }

        // Dummy node to simplify the result list construction

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            if(node.next!=null) {
                queue.add(node.next);
            }
        }
        return dummy.next; // Return the merged list starting from dummy.next
    }
}
