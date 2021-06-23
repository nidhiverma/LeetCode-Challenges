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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = head, end = head, prev = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        prev = dummy;
        
        while(left-- > 1 && right-- > 1) {
            prev = start;
            start = start.next;
            end = end.next;
        }
        
        while(right-- > 1) {
            end = end.next;
        }
        
        prev.next = end.next;
        end.next = null;
        
        ListNode rev = reverse(start);
        start.next = prev.next;
        prev.next = rev;
        return dummy.next;
    }
    
    private ListNode reverse(ListNode node) {
        if(node == null) return node;
        ListNode head = node, temp = null;
        
        while(node.next != null) {
            temp = node.next;
            node.next = temp.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }
} 