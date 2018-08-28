/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry =0;
        ListNode result1 = new ListNode(0);
        ListNode result = result1;
        
        /*if (l1 == null && l2 == null)
        {
            return new ListNode(0);
        }*/
        
        while (l1 != null || l2 != null)
        {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            //System.out.println("result: " + result.val);
            if (l1!=null)
            {
                l1 = l1.next;
            }
            if (l2!=null)
            {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
           result.next = new ListNode(carry);
        }
        return result1.next;
    }
}
