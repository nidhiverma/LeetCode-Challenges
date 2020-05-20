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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        
        ListNode evenH = null, oddH = null, evenT = null, oddT = null, curr = head;
        int index = 1;
        
        while(head != null) {
            if(index % 2 == 0) {
                if(evenT == null) {
                    evenH = evenT = head;
                }
                else {
                    evenT.next = head;
                    evenT = evenT.next;
                }
            }
            else {
                if(oddT == null) {
                    oddH = oddT = head;
                }
                else {
                    oddT.next = head;
                    oddT = oddT.next;
                }
            }
            index++;
            head = head.next;
        }
        if(evenH == null) {
            oddT.next = null;
        }
        else {
            oddT.next = evenH;
            evenT.next = null;
        }
        return oddH;
    }
}
