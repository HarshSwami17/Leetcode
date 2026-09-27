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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode start = null;
        while (curr != null) {
            ListNode newnode = curr.next;
            curr.next = prev;
            prev.next = newnode;
            if (start != null) {
                start.next = curr;
            } else {
                head = curr;
            }
            start = prev;
            prev = newnode;
            if (newnode != null) {
                curr = newnode.next;
            } else {
                curr = null;
            }

        }
        return head;

    }

}