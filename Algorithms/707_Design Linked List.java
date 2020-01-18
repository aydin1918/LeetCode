class MyLinkedList {
    
    public ListNode head;
    
    class ListNode
    {
        ListNode prev;
        ListNode next;
        int val;
        public ListNode(int val)
        {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        ListNode list = new ListNode(0);
        list.next = head;
        list.prev = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //System.out.println("get method");
        ListNode list = head;
        int curr = 0;
        while (list != null)
        {
            //System.out.println(list.val);
            if (index == curr++)
            {
                return list.val;
            }
            //curr++;
            list = list.next;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode list = head;
        ListNode newNode = new ListNode(val);
        head = newNode;
        newNode.next = list;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode list = head;
        while (list.next!=null)
        {
            list = list.next;
        }
        ListNode newNode = new ListNode(val);
        list.next = newNode;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int curr = 0;
        ListNode list = head, prev = null;
        ListNode newNode = new ListNode(val);
        
        if (index==0){
            head = newNode;
            newNode.next = list;
            return;
        }
        
        while(curr++<index)
        {
            prev = list;
            list = list.next;
        }
        
        if (prev!=null){
            
            newNode.next = list;
            prev.next = newNode;
        }
        
    }
    
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode list = head, prev = null;
        int curr = 0;
        
        if (index == 0){
            ListNode temp = list.next;
            head = temp;
            return;
        }
        
        while (curr != index-1)
        {
            //prev = list;
            list = list.next;
            curr++;
        }
        
        /*if (prev!=null)
        {
            //ListNode temp = prev;
            prev = list.next.next;
            list.next = prev;
        }*/
        if (list==null || list.next==null) return;
        
        ListNode next = list.next.next;
        list.next = next;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
