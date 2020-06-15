/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) return null;
        TreeMap<Integer, List<Node>> map = new TreeMap();
        
        inOrder(root, map, new Node(0, 0) );
        
        //System.out.println(map);
        
        for (Map.Entry<Integer, List<Node>> el : map.entrySet()){
            //ans.add(el.getValue());
            List<Integer> temp = new ArrayList();
            for (Node n : el.getValue()){
                temp.add(n.key);
            }
            ans.add(temp);
        }
        
        //System.out.println(ans);
        
        return ans;
    }
    
    private void inOrder(TreeNode root,TreeMap<Integer, List<Node>> map, Node position )
    {
        if (root == null) return;
        
        Node node = new Node(root.val, position.x, position.y);
        
        map.putIfAbsent(node.y, new ArrayList());
        List<Node> temp = map.get(node.y);
        temp.add(node);
        Collections.sort(temp, (a,b) -> b.x == a.x ? a.key - b.key : b.x - a.x);
        map.put(node.y, temp);
        
        inOrder(root.left, map, new Node(position.x-1, position.y-1) );
        
        inOrder(root.right, map, new Node(position.x-1, position.y+1) );
        
    }
    
    class Node {
        int key;
        int x;
        int y;
        public Node(int key, int x, int y){
            this.key = key; 
            this.x = x;
            this.y = y;
        }
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
