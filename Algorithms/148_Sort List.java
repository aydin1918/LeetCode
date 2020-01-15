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
        ListNode result = null;
        if (left == null) return right;
        if (right == null) return left;
        
        if (left.val <= right.val){
            result = left;
            result.next = sortElements(left.next, right);
        }
        else{
            result = right;
            result.next = sortElements(left, right.next);
        }
        
        return result;
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
