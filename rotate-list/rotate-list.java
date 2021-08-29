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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) 
            return head;
        
        ListNode first = head, second = head, prev = null;
        k %= length(head);
       
        if(k == 0) return head;
        
        while(k-- > 1) {
            first = first.next;
        }
        
        while(first != null && first.next != null) {
            prev = second;
            second = second.next;
            first = first.next;
        }
        
        prev.next = null;
        first.next = head;
        return second;
        
    }
   
    public int length(ListNode head) {
        ListNode curr = head;
        int len = 0;
        
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
} 
