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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;
        
        return travel(root, t1, t2);
    }
    
    public TreeNode travel(TreeNode root, TreeNode t1, TreeNode t2)
    {
        if (t1!=null && t2!=null){
            root = new TreeNode(t1.val + t2.val);
            root.left = travel(root.left, t1.left, t2.left);
            root.right = travel(root.right, t1.right, t2.right);
             return root;
        }
        if (t1==null && t2==null){
            return root;
        }
        if (t1!=null && t2==null){
            root = new TreeNode(t1.val);
            root.left = travel(root.left, t1.left, t2);
            root.right = travel(root.right, t1.right, t2);
             return root;
        }
        if (t1==null && t2!=null){
            root = new TreeNode(t2.val);
            root.left = travel(root.left, t1, t2.left);
            root.right = travel(root.right, t1, t2.right);
             return root;
        }
        return root;
    }
}
