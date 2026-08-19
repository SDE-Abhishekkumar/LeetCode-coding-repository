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

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode start = head;
        int count = 1;

        while(curr != null){
            if(count % k == 0){
                ListNode temp = curr.next;
                curr.next = null;

                // reverse k-group
                ListNode rev = reverse(start);

                if(prev != null) {
                    prev.next = rev;
                } else {
                    head = rev; // new head
                }

                prev = start;  // start becomes the tail after reverse
                start = curr = temp; // next block start
            } else {
                curr = curr.next;
            }
            count++;
        }

        // attach leftover nodes (less than k)
        if(prev != null) prev.next = start;

        return head;
    }
}