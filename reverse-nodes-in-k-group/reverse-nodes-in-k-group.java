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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = new ListNode(-1), curr = head;
        ListNode dummy = prev;
        prev.next = head;
        int i = k;
        while(true) {
            while(i-- > 1 && curr != null) {
                curr = curr.next;
            }
            if(curr == null) break;
            
            // reverse
            ListNode tail = curr;
            ListNode start = prev.next;
            
            prev.next = curr.next;
            tail.next = null;
            
            // reverse list  
            ListNode rev = reverse(start);
        
            start.next = prev.next;
            prev.next = rev;
            
            // curr = reverse list tail.next
            curr = start.next;
            // prev = reverse list tail 
            prev = start;
            i = k;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode revHead = head, next = null;
        
        while(head.next != null) {
            next = head.next;
            head.next = next.next;
            next.next = revHead;
            revHead = next;
        }
        return revHead;
    } 
}