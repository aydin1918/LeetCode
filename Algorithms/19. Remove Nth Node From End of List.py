# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        l = []
        while head:
            val = 0
            val += head.val
            head = head.next
            l.append(val)
            
        del l[(-1)*n]    
        
        return l
