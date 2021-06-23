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
    ListNode res = null, tail = null;
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        res = new ListNode(head.val);
        tail = res;
        ListNode curr = head.next;
        
        while(curr != null) {
            insertionSort(curr);
            curr = curr.next;
        }
        return res;
    }
    
    private void insertionSort(ListNode head) {
        ListNode newNode = new ListNode(head.val);
        
        // last node
        if(tail.val <= head.val) {
            tail.next = newNode;
            tail = tail.next;
            return;
        }
        
        // first node
        else if(res.val >= head.val) {
            newNode.next = res;
            res = newNode;
            return;
        }
        ListNode curr = res;
        while(curr != null && curr.next != null && curr.next.val < newNode.val) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;    
        return;
    }
}