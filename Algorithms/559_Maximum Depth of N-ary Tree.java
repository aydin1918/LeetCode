/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if(root == null) {
             return 0;
        }
         
         Queue<Node> queue = new LinkedList<>();
         int depth = 0;
         queue.add(root);
        
         while(!queue.isEmpty())
         {
             int size = queue.size();
             
             for (int i=0; i<size; i++)
             {
                 Node current = queue.poll();
                 for (Node child : current.children)
                 {
                     queue.add(child);
                 }
             }
             
             depth++;
             
         }
        
        return depth;
    }
}
