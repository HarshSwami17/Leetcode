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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int sz = 0;
        ListNode curr = head;
        while (curr != null) {
            sz++;
            curr = curr.next;
        }
        if(sz == n){
            head = head.next;
        }
        else{
        int last = sz - n;
        ListNode prevNode = head;
        ListNode currNode = head.next;
        if (last < 1) {
            head = null;
        } else {
            for (int i = 1; i < last; i++) {
                prevNode = prevNode.next;
                currNode = currNode.next;
            }
            prevNode.next = currNode.next;
        }
        }
        return head;

    }
}