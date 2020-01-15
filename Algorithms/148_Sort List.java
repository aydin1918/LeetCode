/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        return mergeSort(head);
    }
    
    private ListNode sortElements(ListNode left, ListNode right)
    {
        if (left == null) return right;
        if (right == null) return left;
        
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        
        while (left!=null && right!=null)
        {
            if (left.val < right.val){
                dummy.next = left;
                left = left.next;
            }
            else{
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        
        if (left!=null) {
            dummy.next = left;
        }
        
        if (right !=null){
            dummy.next = right;
        }
        
        return result.next;
    }
    
    private ListNode mergeSort(ListNode node)
    {
        if (node == null || node.next == null) return node;
        
        ListNode middle = getMiddle(node);
        ListNode nextMiddle = middle.next;
        // break current node - no next 
        middle.next = null;
        // break left and right into parts
        ListNode left = mergeSort(node);
        ListNode right = mergeSort(nextMiddle);
        return sortElements(left, right);
    }
    
    private ListNode getMiddle(ListNode node)
    {
        if (node == null) return node;
        
        ListNode slow = node, fast = node;
        
        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
