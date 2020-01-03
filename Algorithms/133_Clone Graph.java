/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    
    public HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        //return clone(node);
        
        if (node == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        
        Node newNode = new Node(node.val, new ArrayList<>());
        queue.add(node);
        map.put(node, newNode);
        
        while (!queue.isEmpty())
        {
            Node current = queue.remove();
            
            for (Node neighbor1 : current.neighbors)
            {
                if (!map.containsKey(neighbor1))
                {
                    Node temp = new Node(neighbor1.val, new ArrayList<>());
                    map.put(neighbor1, temp);
                    queue.add(neighbor1);
                }
                map.get(current).neighbors.add(map.get(neighbor1));
            }
            
        }
        
        return map.get(node);
        
    }
    
    
    
    public Node clone(Node node)
    {
        if (node == null) return null;
        
        if (map.containsKey(node.val)) return map.get(node.val);
        
        Node newNode = new Node(node.val, new ArrayList<>());
        
        map.put(newNode.val, newNode);
        
        for (Node neighbors1 : node.neighbors)
        {
            newNode.neighbors.add(clone(neighbors1));
        }
        
        return newNode;
        
    }
    
}
