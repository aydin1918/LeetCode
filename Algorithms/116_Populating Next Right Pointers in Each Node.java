/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        
        while (!queue.isEmpty()){
            
            int size = queue.size();
            Node prev = null;
            while (size>0){
                Node curr = queue.remove();
                if (prev != null){
                    prev.next = curr;
                }
                
                if (curr.left != null){
                    queue.add(curr.left);
                }
                
                if (curr.right != null){
                    queue.add(curr.right);
                }
                
                prev = curr;
                size--;
            }
            
        }
        
        return root;
    }
    
}
