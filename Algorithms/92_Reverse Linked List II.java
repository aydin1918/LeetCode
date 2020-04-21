/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode prev =  null;
        dummy.next = head;
        
        for (int i=0; i<m; i++){
            prev = curr;
            curr = curr.next;
        }
        
        ListNode curr2 = curr, next = null, prev2 = prev;
        
        for (int i=m; i<=n; i++){
            next = curr2.next;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = next;
        }
        
        prev.next = prev2;
        curr.next = curr2;
        
        return dummy.next ;
    }
}
