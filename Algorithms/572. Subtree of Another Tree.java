/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        return valTree(s,t);
        
    }
    
    public static boolean travelTree(TreeNode s, TreeNode t)
    {
        if (s == null && t==null)
        {
          // result = true;
            return true;
        }
        
        if (s ==null || t == null)
        {
            //result = false;
            return false;
        }
            
        return s.val == t.val && travelTree(s.left, t.left) && travelTree(s.right, t.right);
        
    }
    
    public static boolean valTree(TreeNode s, TreeNode t)
    {
        
        
        return s!= null && (travelTree(s, t) || valTree(s.left, t) || valTree(s.right, t));            
    }
    
    
}
